package IO;

import Judge.Tester;
import Network.DownloadMenager;
import Repository.StudentsRepository;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String input) {

        String[] data = input.split("\\s+");
        String command = data[0];
        switch (command) {
            //open {filename}
            case "open":
                tryOpenFile(input, data);
                break;
            //mkdir {directoryName}
            case "mkdir":
                tryCreateDirectory(input, data);
                break;
            //ls {depth}
            case "ls":
                tryTraverseDirectory(input, data);
                break;
            //cmp {absolute filePath1} {absolute filePath2}
            case "cmp":
                tryCompareFiles(input, data);
                break;
            //changeDirRel {relative filepath}
            case "changeDirRel":
                tryChangeRelativePath(input, data);
                break;
            //changeDirAbs {absolute filepath}
            case "changeDir":
                tryChangeAbsolutePath(input, data);
                break;
            //readDb {filePath}
            case "readDb":
                tryReadDatabaseFromFile(input, data);
                break;
            //show {courseName} ({username})
            case "show":
                tryShowWantedCourse(input, data);
                break;
            case "filter":
                tryPrintFilteredStudents(input, data);
                break;
            case "order":
                tryPrintOrderedStudents(input, data);
                break;
            case "download":
                tryDownloadFile(input, data);
                break;
            case "downloadAsync":
                tryDownloadFileOnNewThread(input, data);
                break;
            case "help":
                OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
                OutputWriter.writeMessageOnNewLine("ls (depth) - traverse directory");
                OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
                OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
                OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
                OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
                OutputWriter.writeMessageOnNewLine("order courseName ascending (limit of students) - sort students in increasing order (the output is written on the console)");
                OutputWriter.writeMessageOnNewLine("filter courseName average - filter average students");
//                IO.OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
//                IO.OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
//                IO.OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
//                IO.OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
//                IO.OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
//                IO.OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
//                IO.OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
//                IO.OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
                OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
                OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
                OutputWriter.writeMessageOnNewLine("show courseName (username) – user name is optional");
                OutputWriter.writeMessageOnNewLine("help - get help");
                OutputWriter.writeEmptyLine();
                break;
            default:
                displayInvalidCommandMessage(input);
                break;
        }
    }

    private static void tryDownloadFileOnNewThread (String input, String[] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }
        String fileUrl = data[1];
        DownloadMenager.downloadOnNewThread(fileUrl);
    }

    private static void tryDownloadFile (String input, String[] data){
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }
        String fileUrl = data[1];
        DownloadMenager.download(fileUrl);
    }

    private static void tryPrintOrderedStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }
        String course = data[1];
        String comparingType = data[2];

        if (data.length == 3) {
            StudentsRepository.printSortedStudents(course, comparingType, null);
        }
        if (data.length == 4) {
            Integer numberOfStudents = Integer.valueOf(data[3]);
            StudentsRepository.printSortedStudents(course, comparingType, numberOfStudents);
        }
    }

    private static void tryPrintFilteredStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommandMessage(input);
            return;
        }
        String course = data[1];
        String filter = data[2];

        if (data.length == 3) {
            StudentsRepository.printFilteredStudents(course, filter, null);
        }
        if (data.length == 4) {
            Integer numberOfStudents = Integer.valueOf(data[3]);
            StudentsRepository.printFilteredStudents(course, filter, numberOfStudents);
        }
    }

    private static void tryShowWantedCourse(String input, String[] data) {
        if (data.length != 2 && data.length != 3) {
            displayInvalidCommandMessage(input);
            OutputWriter.writeMessageOnNewLine("Use this format \"show {courseName} ({username})\"");
            return;
        }
        if (data.length == 2) {
            String courseName = data[1];
            StudentsRepository.getStudentsByCourse(courseName);
        }
        if (data.length == 3) {
            String courseName = data[1];
            String userName = data[2];

            StudentsRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            OutputWriter.writeMessageOnNewLine("Use this format \"open {filename}\" for that command");
            return;
        }
        String fileName = data[1];
        try {
            StudentsRepository.initializeData(fileName);
        } catch (IOException e) {
            OutputWriter.writeMessageOnNewLine("File not found");
        }
    }

    private static void tryChangeAbsolutePath(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String absolutePath = data[1];
        IOManager.changeCurrentDirAbsolute(absolutePath);
    }

    private static void tryChangeRelativePath(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryCompareFiles(String input, String[] data) {
        if (data.length != 3) {
            displayInvalidCommandMessage(input);
            return;
        }
        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryTraverseDirectory(String input, String[] data) {
        if (data.length != 1 && data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        if (data.length == 1) {
            IOManager.traverseDirectory(0);
        }
        if (data.length == 2) {
            int depth = Integer.parseInt(data[1]);
            IOManager.traverseDirectory(depth);
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            OutputWriter.writeMessageOnNewLine("Use this format \"mkdir {folderName}\"for that command");
            return;
        }
        String directoryName = data[1];
        IOManager.createDirectoryInCurrentFolder(directoryName);
    }

    private static void tryOpenFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }
        String filename = data[1];
        String filepath = SessionData.currentPath + "\\" + filename;
        File file = new File(filepath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }
}

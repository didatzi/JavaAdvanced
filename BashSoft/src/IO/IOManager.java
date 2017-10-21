package IO;

import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.util.LinkedList;

public class IOManager {

    public static void changeCurrentDirRelativePath(String relativePath){
        if ("..".equals(relativePath)){
            String currentPath = SessionData.currentPath;
            int indexOfLastSlash  = currentPath.lastIndexOf("\\");
            String newPath = currentPath.substring(0, indexOfLastSlash);
            SessionData.currentPath = newPath;
        }else{
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }
        SessionData.currentPath = absolutePath;
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static void traverseDirectory(int depth) {
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            //Dequeue the folder at the start of the queue
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if ((depth - currentIndentation) < 0) {
                break;
            }
            //Print the current folder
            printFolder(currentFolder);

            //add all its subFolders to the end of the queue
            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        //Enqueue all subFolders
                        subFolders.add(file);
                    } else {
                        //print all files in current folder
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }
                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
        }
    }

    private static void printFolder(File currentFolder) {
        try {
            OutputWriter.writeMessageOnNewLine(currentFolder.toString());
        } catch (Exception e) {
            OutputWriter.displayException(ExceptionMessages.Access_Denied_Exception);
        }
    }

    public static String getCurrentDirectoryPath() {
        return SessionData.currentPath;
    }
}

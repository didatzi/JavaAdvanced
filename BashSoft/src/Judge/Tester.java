package Judge;

import IO.OutputWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void compareContent(String actualOutput, String expectedOutput) {
        OutputWriter.writeMessageOnNewLine("Reading files...");
        String mismatchPath = getMismatchPath(expectedOutput);

        List<String> actualOutputString = readTextFile(actualOutput);
        List<String> expectedOutputString = readTextFile(expectedOutput);

        boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);
        if (mismatch){
            List<String> mismatchString = readTextFile(mismatchPath);
            mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
        }else{
            OutputWriter.writeMessageOnNewLine("Files are identical. There are no mismatches.");
        }
    }

    private static boolean compareStrings(List<String> actualOutputString, List<String> expectedOutputString, String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;


        try (FileWriter fileWriter = new FileWriter(mismatchPath);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            int mismatchCounter = 0;

            //Compare line by line
            for (int i = 0; i < expectedOutputString.size(); i++) {
                String actualLine = actualOutputString.get(i);
                String expectedLine = expectedOutputString.get(i);

                if (!actualLine.equals(expectedLine)) {
                    output = String.format("mismatch -> expected{%s}, actual{%s}%n", expectedLine, actualLine);
                    isMismatch = true;
                    mismatchCounter++;
                } else {
                    output = String.format("line match -> actual{%s}%n", actualLine);
                }
                // Write result to a file
                writer.write(output);
            }

            writer.close();
        } catch (IOException e) {
            OutputWriter.displayException("Error.");
        }  catch (IndexOutOfBoundsException e){
            OutputWriter.displayException("Error. File is missing.");
            OutputWriter.writeEmptyLine();
            isMismatch = true;
        }


        return isMismatch;
    }

    private static List<String> readTextFile(String filePath) {
        List<String> text = new ArrayList<>();
        try {
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            //read lines until empty line is read
            while (!line.isEmpty()) {
                //Save lines in list
                text.add(line);
                line = reader.readLine();
                if (line == null){
                    break;
                }
            }
            //Close the reader
            reader.close();
        } catch (IOException e) {
            OutputWriter.writeMessageOnNewLine("File not found.");
        } catch (NullPointerException e){

        }
        return text;
    }

    private static String getMismatchPath(String expectedOutput) {
        try {
            int index = expectedOutput.lastIndexOf('\\');
            String directoryPath = expectedOutput.substring(0, index);
            return directoryPath + "\\mismatch.txt";
        }catch (StringIndexOutOfBoundsException e){
            return "mismatch.txt";
        }
    }


}

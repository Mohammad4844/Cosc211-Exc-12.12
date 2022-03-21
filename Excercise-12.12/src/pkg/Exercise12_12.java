package pkg;

import java.util.*;
import java.io.*;

/**
 * A program which formats code from 'next line' brace style to the 'end of line' brace style. Is
 * run form the command line (type in the name of the files that need to be formatted as
 * parameters).
 * <p>
 * Note: the program doesn't work when there is an empty line in the code (a gap). This is how the
 * original code functioned as well.
 */
public class Exercise12_12 {

  /**
   * Checks if there is a parameter entered through the command line.
   */
  private void checkCommandLineParameters(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }

  /**
   * Checks if file that is to be formatted exists Returns the file if it does.
   */
  private File checkIfSourceFileExists(String fileName) {
    File sourceFile = new File(fileName);
    if (!sourceFile.exists()) {
      System.out.println("Source file " + fileName + " not exist");
      System.exit(2);
    }
    return sourceFile;
  }

  /**
   * Changes the contents of the file that is passed in as a parameter
   */
  private void changeFileContent(File sourceFile) throws FileNotFoundException {
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);
    formatWholeFile(buffer, input);
    outputBufferToFile(sourceFile, buffer);
  }

  /**
   * Formats the code from 'next line' brace style to the 'end of line' brace style
   */
  private void formatWholeFile(StringBuilder buffer, Scanner input) {
    while (input.hasNext()) {
      String line = input.nextLine();
      String trimmedLine = line.trim();
      formatLine(buffer, line, trimmedLine);
    }
    buffer.delete(0, 2); // Prevents the addition of a newline at the start of the code
  }

  /**
   * Formats each individual line (or pair of lines - 2), checking the braces and doing the
   * necessary replacements
   */
  private void formatLine(StringBuilder buffer, String line, String trimmedLine) {
    if (trimmedLine.charAt(0) == '{') {
      buffer.append(" {");
      if (trimmedLine.length() > 1)
        buffer.append("\r\n" + line.replace('{', ' '));
    } else
      buffer.append("\r\n" + line);
  }

  /**
   * Outputs the formatted text back to the file
   */
  private void outputBufferToFile(File sourceFile, StringBuilder buffer)
      throws FileNotFoundException {
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }

  public static void main(String[] args) throws FileNotFoundException {
    Exercise12_12 program = new Exercise12_12();
    program.checkCommandLineParameters(args);
    File sourceFile = program.checkIfSourceFileExists(args[0]);
    program.changeFileContent(sourceFile);
  }
}

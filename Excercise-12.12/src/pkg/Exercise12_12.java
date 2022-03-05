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
  private static void checkCommandLineParameters(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }

  /**
   * Checks if file that is to be formatted exists
   */
  private static void checkIfSourceFileExists(String[] args) {
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
      System.out.println("Source file " + args[0] + " not exist");
      System.exit(2);
    }
  }

  /**
   * Changes the contents of the file that is passed in as a parameter
   */
  private static void changeFileContent(File sourceFile) throws FileNotFoundException {
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);
    buffer = formatWholeFile(buffer, input);
    outputBufferToFile(sourceFile, buffer);
  }

  /**
   * Formats the code from 'next line' brace style to the 'end of line' brace style
   */
  public static StringBuilder formatWholeFile(StringBuilder buffer, Scanner input) {
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      buffer.append(formatLine(s, s1));
    }
    buffer.delete(0, 2); // Prevents the addition of a newline at the start of the code
    return buffer;
  }

  /**
   * Formats each individual line (or pair of lines - 2), checking the braces and doing the
   * necessary replacements
   */
  public static String formatLine(String s, String s1) {
    return (s1.charAt(0) == '{') ? (s1.length() > 1) ? " {" + "\r\n" + s.replace('{', ' ') : " {"
        : "\r\n" + s; //had to rewrite this part like this because simpler if-else took more than 6 lines
  }

  /**
   * Outputs the formatted text back to the file
   */
  private static void outputBufferToFile(File sourceFile, StringBuilder buffer) throws FileNotFoundException {
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }

  public static void main(String[] args) throws FileNotFoundException {
    checkCommandLineParameters(args);
    checkIfSourceFileExists(args);
    File sourceFile = new File(args[0]);
    changeFileContent(sourceFile);
  }
}

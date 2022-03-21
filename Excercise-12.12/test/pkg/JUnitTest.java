package pkg;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class JUnitTest {

  @Test
  public void testCodeFormatter_TestFile1() throws Exception {
    Exercise12_12.main(new String[] {"test/pkg/TestFile1.java"});
    String actualText = textFromFile("test/pkg/TestFile1.java");
    String expectedText = """
        package pkg;
        public class TestFile1 {
          public static void main(String[] args) {
            // Some statements
          }
        }
        """;
    assertTrue(actualText.equals(expectedText));
  }

  @Test
  public void testCodeFormatter_TestFile2() throws Exception {
    Exercise12_12.main(new String[] {"test/pkg/TestFile2.java"});
    String actualText = textFromFile("test/pkg/TestFile2.java");
    String expectedText = """
        package pkg;
        public class TestFile2 {
          int sampleValue;
          public TestFile2 (int sampleValue) {
            if (sampleValue > 0) {
              this.sampleValue = sampleValue;
            }
            else {
              this.sampleValue = -1;
            }
          }
        }
        """;
    assertTrue(actualText.equals(expectedText));
  }

  /**
   * Helper method that extracts text from a file. Removes unnecessary clutter from the Test methods
   */
  private static String textFromFile(String path) throws FileNotFoundException {
    Scanner input = new Scanner(new File(path));
    String text = "";
    while (input.hasNext()) {
      text += input.nextLine() + "\n";
    }
    return text;
  }
}

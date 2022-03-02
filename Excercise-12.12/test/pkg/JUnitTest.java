package pkg;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class JUnitTest {

  @Test
  public void testCodeFormatter() throws Exception {
    Exercise12_12.main(new String[] {"test/pkg/TestFile1.java"});

    String actualText = textFromFile("test/pkg/TestFile1.java");
    String expectedText = "package pkg;\n" + "public class TestFile1  {\n"
        + "  public static void main(String[] args)  {\n" + "    // Some statements\n" + "  }\n"
        + "}\n";
    assertTrue(actualText.equals(expectedText));
  }

  private static String textFromFile(String path) throws FileNotFoundException {
    Scanner input = new Scanner(new File(path));
    String text = "";
    while (input.hasNext()) {
      text += input.nextLine() + "\n";
    }
    return text;
  }
}

package main.Recipe;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class FileOperations {

  /* Saves the string to a text file */
  public void saveText(String path, String text) {
    try {
      File file = new File(path);
      FileWriter printW = new FileWriter(file);
      printW.write(text + "\n");
      printW.close();
    } catch (IOException e) { e.printStackTrace(); }
  }

  public String toString(String path) {
    StringBuilder text = new StringBuilder();

    try {
      File file = new File(path);
      if (!file.exists()) {
        return "";
      }
      Scanner scan = new Scanner(file);
      while (scan.hasNext()) {
        String str = scan.nextLine();
        text.append(str + "\n");
      }
      scan.close();
    } catch (IOException e) { e.printStackTrace(); }

    return text.toString();
  }
}
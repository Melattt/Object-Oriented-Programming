package main.Recipe;
public class Print {

  public char defSurroundChar = '"';
  public int defSurroundSize = 128;

  /* Surrounds a string with a single character */
  public String SurroundString(String content, int length, char c) {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < length; i++) {
      text.append(c);
    }
    int start = (length / 2) - (content.length() / 2);
    if (length >= content.length()) {
      text.replace(start, start + content.length(), content);
      return text.toString();
    } else {
      return content;
    }
  }

  public String SurroundString(String content, char c) {
    return SurroundString(content, defSurroundSize, c);
  }

  public String SurroundString(String content) {
    return SurroundString(content, defSurroundSize, defSurroundChar);
  }

  /* Prints the resulting string to the console */
  public void surroundPrint(String content, int size, char c) {
    System.out.print(SurroundString(content, size, c));
  }

  public void surroundPrintln(String content, int size, char c) {
    System.out.println(SurroundString(content, size, c));
  }

  public void surroundPrint(String content, char c) {
    System.out.print(SurroundString(content, defSurroundSize, c));
  }

  public void surroundPrintln(String content, char c) {
    System.out.println(SurroundString(content, defSurroundSize, c));
  }

  public void surroundPrint(String content) {
    System.out.print(SurroundString(content, defSurroundSize, defSurroundChar));
  }

  public void surroundPrintln(String content) {
    System.out.println(SurroundString(content, defSurroundSize, defSurroundChar));
  }

  /* Content centered string */
  public String centerString(String content, int length, String frame) {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (i < frame.length()) {
        text.append(frame.charAt(i));
      } else {
        text.append(' ');
      }
    }
    int start = (length / 2) - (content.length() / 2);
    text.replace(start, start + content.length(), content);
    text.replace(length - frame.length(), length, new StringBuilder(frame).reverse().toString());
    return text.toString();
  }

  public String centerString(String content, String frame) {
    return centerString(content, defSurroundSize, frame);
  }

  public void Println(String content) {
    System.out.println(content);
  }

  public void Print(String content) {
    System.out.print(content);
  }
}
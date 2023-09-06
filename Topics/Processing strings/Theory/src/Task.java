import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String token = scanner.next();
    char[] tokens = token.toCharArray();
    for (int i = 0; i < tokens.length; i++) {
      System.out.println(tokens[i]);
    }
  }
}

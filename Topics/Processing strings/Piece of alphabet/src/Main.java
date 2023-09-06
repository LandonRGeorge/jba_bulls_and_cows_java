import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String token = scanner.next();
        char[] tokens = token.toCharArray();
        if (tokens.length == 1) {
            System.out.println(true);
            return;
        }
        int prevChar = (int) tokens[0];
        boolean sorted = true;
        for (int i = 1; i < tokens.length; i++) {
            int currentChar = (int) tokens[i];
            if (currentChar - 1 != prevChar) {
                sorted = false;
                break;
            }
            prevChar = currentChar;
        }
        System.out.println(sorted);
    }
}

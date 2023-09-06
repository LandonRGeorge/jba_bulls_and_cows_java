package bullscows;

import java.util.*;

public class Main {
    public static String generateSecretCode(int codeLength, int nbrSymbols) {
        StringBuilder sb = new StringBuilder();

        Random r = new Random();
        int minSymbolInt = 'a';
        int maxSymbolInt = 'a' + nbrSymbols - 11;

        while (sb.length() < codeLength) {

            String val;
            if (nbrSymbols > 10 && r.nextBoolean()) {
                int randomNumber = r.nextInt(nbrSymbols - 9);
                val = String.valueOf((char) (minSymbolInt + randomNumber));
            } else {
                int randomNumber = r.nextInt(Math.min(nbrSymbols, 10));
                val = String.valueOf(randomNumber);
            }
            if (sb.toString().contains(String.valueOf(val))) {
                continue;
            }
            sb.append(val);
        }
        String stars = "*".repeat(codeLength);
        System.out.println("The secret is prepared: " + stars + " (0-9, a-" + (char) maxSymbolInt + ").");
        return sb.toString();
    }

    public static String getGrade(String inputStr, String secretCode) {
        if (inputStr.equals("0")) {
            return "Grade: none";
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            char c1 = inputStr.charAt(i);
            char c2 = secretCode.charAt(i);

            // perfect match
            if (c1 == c2) {
                bulls++;
                continue;
            }

            for (int j = 0; j < secretCode.length(); j++) {
                char c3 = secretCode.charAt(j);
                if (c1 == c3) {
                    cows++;
                    break;
                }

            }
        }
        String grade = bulls > 0 && cows > 0 ? bulls + " bulls" + " and " + cows + " cows" :
                bulls > 0 ? bulls + " bulls" :
                        cows > 0 ? cows + " cows" :
                                "None";
        return "Grade: " + grade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        int secretCodeLength;

        try {
            secretCodeLength = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: \"" + e.getMessage() + "\" isn't a valid number.");
            return;
        }

        if (secretCodeLength < 1) {
            System.out.println("Error: must be greater than 0");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        int nbrPossibleSymbols;
        try {
            nbrPossibleSymbols = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: \"" + e.toString() + "\" isn't a valid number.");
            return;
        }
        if (nbrPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        if (nbrPossibleSymbols < 1) {
            System.out.println("Error: must be greater than 0");
            return;
        }
        if (secretCodeLength > nbrPossibleSymbols) {
            System.out.println("Error: it's not possible to generate a code with a length of " + secretCodeLength);
            return;
        }


        // generate secret code
        String secretCode = generateSecretCode(secretCodeLength, nbrPossibleSymbols);

        // start the game
        System.out.println("Okay, let's start a game!");
        int attempts = 0;

        // repeatedly ask for guess until correct
        while (true) {
            attempts++;
            System.out.println("Turn " + attempts + ":");
            String guess = scanner.next();
            var grade = getGrade(guess, secretCode);
            System.out.println(grade);
            if (guess.equals(secretCode)) {
                break;
            }
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}

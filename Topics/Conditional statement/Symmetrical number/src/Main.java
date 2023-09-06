import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var token = scanner.nextInt();
        int nbr1 = token / 1000;
        int nbr2 = (token - (nbr1 * 1000)) / 100;
        int nbr3 = (token - (nbr1 * 1000) - (nbr2 * 100)) / 10;
        int nbr4 = token - (nbr1 * 1000) - (nbr2 * 100) - (nbr3 * 10);
        boolean condition = nbr1 == nbr4 && nbr2 == nbr3;
        int answer = 42;
        if (condition) {
            answer = 1;
        }
        System.out.println(answer);
    }
}
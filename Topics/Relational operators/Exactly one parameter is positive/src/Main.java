import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nbr1 = scanner.nextInt();
        int nbr2 = scanner.nextInt();
        int nbr3 = scanner.nextInt();
        boolean condition1 = nbr1 > 0 && nbr2 <= 0 && nbr3 <= 0;
        boolean condition2 = nbr2 > 0 && nbr1 <= 0 && nbr3 <= 0;
        boolean condition3 = nbr3 > 0 && nbr1 <= 0 && nbr2 <= 0;
        boolean conditionAll = condition1 || condition2 || condition3;
        System.out.println(conditionAll);
    }
}
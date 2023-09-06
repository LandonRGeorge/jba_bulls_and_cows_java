import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String token = scanner.next();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < token.length(); i++) {
            int nbr = Character.getNumericValue(token.charAt(i));
            if (i < 3) {
                sum1 += nbr;
            } else {
                sum2 += nbr;
            }
        }
        String response = sum1 == sum2 ? "Lucky" : "Regular";
        System.out.println(response);
    }
}
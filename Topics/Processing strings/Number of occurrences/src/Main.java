import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t1 = scanner.nextLine();
        String t2 = scanner.nextLine();
        int nbr = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < t1.length()) {
            if (t1.charAt(i1) != t2.charAt(i2)) {
                i2 = 0;
                i1++;
                continue;
            }
            i1++;
            i2++;
            if (i2 >= t2.length()) {
                i2 = 0;
                nbr += 1;
            }
        }
        System.out.println(nbr);
    }
}
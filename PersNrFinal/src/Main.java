import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean test(String pnr) {

        int sum = 0;

        if (pnr.length() != 10) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            char pers = pnr.charAt(i);
            int persint = Character.digit(pers, 10);

            if (i % 2 == 0) {
                persint = persint * 2;
            }

            if (persint >= 10) {
                persint = persint - 10 + 1;
            }

            sum = sum + persint;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv ett personnummer: ");
        String pn = sc.nextLine();
        if (pn.length() != 10) {
            System.out.print("Felaktig inmatning");

        } else {
            int m = Integer.parseInt(pn.substring(2, 4));
            int n = Integer.parseInt(pn.substring(4, 6));

            if (m < 13 && n < 31) {
                if (test(pn)) {
                    char hen = pn.charAt(8);
                    int henint = Character.digit(hen, 10);
                    System.out.println("Du har ett giltigt personnummer");
                    System.out.println("Du är född " + pn.substring(4, 6) + "/" + pn.substring(2, 4) + " -" + pn.substring(0, 2));
                    if (henint % 10 == 0) {
                        System.out.println("Du är en kvinna");
                    }
                    else {
                        System.out.println("Du är en man");
                    }
                } else {
                    System.out.println("Du har inte ett giltigt personnummer");
                }

            } else if (m > 12) {
                if (test(pn)) {
                    char org = pn.charAt(0);
                    int orgint = Character.digit(org, 10);

                    if (orgint == 1)
                    System.out.println("Du har skrivit ett giltigt organisationsnummer av typen dödsbon");
                    else if (orgint == 2)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen stat, landsting, kommuner, församlingar");
                    else if (orgint == 3)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen utländska företag som bedriver näringsverksamhet eller äger fastighet i Sverige");
                    else if (orgint == 5)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen aktiebolag");
                    else if (orgint == 6)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen enkelt bolag");
                    else if (orgint == 7)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen ekonomiska föreningar");
                    else if (orgint == 8)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen ideella föreningar och stiftelser");
                    else if (orgint == 9)
                        System.out.println("Du har skrivit ett giltigt organisationsnummer av typen handelsbolag, kommanditbolag och enkla bolag");

                } else {
                    System.out.println("Du har skrivit ett felaktigt organisationsnummer");
                }

            } else if (n >= 60) {
                if (test(pn)) {
                    System.out.println("Du har skrivit ett giltigt sammordningsnummer");
                } else {
                    System.out.println("Du har skrivit ett ogiltigt sammordningsnummer");
                }
            }
        }
    }
}

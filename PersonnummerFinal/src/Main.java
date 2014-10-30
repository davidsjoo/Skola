import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        //System.out.print("Skriv ett personnummer eller ett organisationsnummer, med 10 siffror: ");
        String persnr = "8702171953";

        if (persnr.length() != 10) {
            System.out.print("Felaktig inmatning");
        }

        else {
            int m = Integer.parseInt (persnr.substring(2, 4));
            int n = Integer.parseInt(persnr.substring(4, 6));
            if (m < 13 && n < 31)  {

                for (int i = 0; i < 10; i++) {
                      char pers = persnr.charAt(i);
                    int persint = Character.digit(pers, 10);

                    if (i % 2 == 0) { //Kollar om positionen som "i" har är jämnt delbar med 2 dvs: 0,2,4 osv..
                        persint = persint * 2;
                    }

                    if (persint >= 10) {
                        persint = persint - 10 + 1;
                    }

                    sum = sum + persint;
                }

                if (sum % 10 == 0) {
                    System.out.println("Du har ett giltigt personnummer!");
                }
                else {
                    System.out.println("Du har inte ett giltigt personnummer!");
                }

                char hen = persnr.charAt(8);
                int henint = Character.digit(hen, 10);

                if (henint % 2 == 0) {
                    System.out.println("Du är en kvinna");
                } else {
                    System.out.println("Du är en man");
                }
                System.out.println("Du är född " + n + "/" + m);

            }

            else if (m > 12 && m < 20) {
                System.out.println("Felaktig inmatning");
            }

            else if ( m > 20) {
                for (int x = 0; x < 10; x++) {
                    char org = persnr.charAt(x);
                    int orgint = Character.digit(org, 10);

                    if (x % 2 == 0) { //Kollar om positionen som "i" har är jämnt delbar med 2 dvs: 0,2,4 osv..
                        orgint = orgint * 2;
                    }

                    if (orgint >= 10) {
                        orgint = orgint - 10 + 1;
                    }

                    sum = sum + orgint;
                }

                if (sum % 10 == 0) {
                System.out.println("Du har skrivit ett giltigt organisationsnummer");
                }
                else {
                System.out.println("Du har skrivit ett felaktigt organisationsnummer");
                }
            }

            else if (n > 60) {
                for (int y = 0; y < 10; y++) {
                    char sam = persnr.charAt(y);
                    int samint = Character.digit(sam, 10);

                    if (y % 2 == 0) { //Kollar om positionen som "i" har är jämnt delbar med 2 dvs: 0,2,4 osv..
                        samint = samint * 2;
                    }

                    if (samint >= 10) {
                        samint = samint - 10 + 1;
                    }

                    sum = sum + samint;
                }

                if (sum % 10 == 0) {
                    System.out.println("Du har skrivit ett giltigt samordningsnummer");
                }
                else {
                    System.out.println("Du har skrivit ett felaktigt samordningsnummer");
                }

            }

        }





    }
}



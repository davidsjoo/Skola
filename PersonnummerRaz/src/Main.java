import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
     * Vi börjar programmet med att definera två listor "arrays", en tom som kommer innehålla alla siffror i personnummret vid namn digits.
     * Vi har också en lista vid namn types som innehåller alla typer av organisationer som kan representeras i ett organisationsnummer, dessa kommer vi åt via types[0-7].
     */
    private static List<Integer> digits = new ArrayList<Integer>();
    //Den tomma stringen i början av listan gör att vi puttar alla andra ett steg uppåt (Så dödsbo blir nummer 1 etc.) och kan därav läsa direkt ur denna listan med infon vi får
    //ur organisationsnummret.
    private static String[] types = {"", "Dödsbo", "Statligt", "Utländskt", "Aktiebolag", "Enkelt bolag", "Ekonomisk förening", "Ideella föreningar / Stiftelser", "Handelsbolag" };
    /*
     * Sjävla koden som validerar personnummer bryter vi bort från main funktionen för att enklare kunna unit-testa själva logiken/algorithm, då vi bara behöver ett ja eller nej (true, false)
     * så returnerar funktionen en boolean och har ingen direkt output mot användaren.
     */
    public static boolean verify(String pn) {
        //Vi börjar funktionen med att återställa sum (Summan av alla tal) samt digits så att dessa inte påverkar resultatet av det nya personummret
        digits.clear();
        int sum = 0;
        //Då alla giltiga personnummer i sverige är 10 siffror (12 om man inkluderar 19 / 20) kan vi göra en "early exit" ifall antalet inte stämmer och strunta i att köra resten av funktionen (return avbryter funktioner)
        //"pn" står för personnummer och är en String som skickas in i funktionen som ett argument
        //Längd kollas även i main funktionen men behövs här med för att kunna testa programmet direkt mot verify funktionen.
        if(pn.length() != 10) {
            return false;
        }
        //Då är det dags att kolla igenom våran input lite nogrannare, eftersom vi kollade ovan vet vi att det finns 10 tecken i Stringen pn
        //Och kan därför kolla position 0 till 9 utan att riskera någon error att vi försöker kolla upp ett objekt som inte finns.
        for (int i = 0; i < 10; i++) {
            //Vi börjar med att kolla om tecknet faktiskt är en siffra imellan 0 och 9, annars utnjyttjar vi återigen "early exit" och avslutar funktionen
            if(!Character.isDigit(pn.charAt(i))) {
                return false;
            }
            //Om det är en siffra skickar vi in siffran i digits för att enklare kunna hantera den sen. "- '0'" är ett fulhack för att omvandla siffran till ett heltal.
            digits.add(pn.charAt(i) - '0');
        }
        //Då var det dags att räkna på personnummret, vi börjar igenom att loopa igenom varje siffra i personnummret var och en för sig
        for(int i = 0; i < digits.size(); i++) {
            //Här sätter vi temp till siffran vi just nu läser ur digits
            int temp = digits.get(i);
            //Beroende på om talet är jämnt eller inte ska det gångras med 1 eller 2, då  temp * 1 fortfarande är samma sak som temp behöver vi bara bry oss om temp * 2.
            if((i % 2) == 0) temp = temp * 2;
            //Om temp är över tar vi bort 9 från temp, annars låter vi det vara.
            temp = (temp > 9) ? temp - 9 : temp;
            //Vi uppdaterar sedan sum med vårat nya värde, sum += temp betyder samma sak som sum = sum + temp.
            sum += temp;
        }
        //Nu har vi loopat igenom alla våra tal och har en summa, denna delar vi med 10 och kollar så att vi INTE får någon rest över, då är det ett giltigt personnummer.
        //Vi returnerar true / false baserat på resultatet.
        return (sum % 10 == 0);
    }
    /*
     * funktionen main är vårat ansikte utåt, den sköter kommunikationen med konsollen.
     */
    public static void main(String[] args) {
        //Vi börjar funktionen med att initiera en scanner, den borde ni känna igen från första uppgiften men kort och gott så låter den er läsa data som en användare skriver i konsollen.
        Scanner sc = new Scanner(System.in);
        //Vi börjar sedan loopa på true, detta är inget jag vanligtvist rekommenderar då denna loop aldrig kommer stanna, men eftersom vi kommer låta användaren testa nya personnummer tills
        //dem stänger av programmet är det en acceptabel lösning i vårat fall.
        while(true) {
            //Vi börjar med att ge användaren en uppmaning, sedan väntar vi på att få input ifrån konsollen
            System.out.println("Skriv in ett personnummer: ");
            String pn = sc.nextLine();
            //Då vi avgör om det är ett personnummer, samordningsnummer eller organisationsnummer måste vi kolla så att längden är minst 10 här med för att inte få en array out of bounds error
            //när vi försöker läsa ur kontrollsiffrorna för samordningsnummer och organisationsnummer.
            if(pn.length() != 10) {
                System.out.println("Ditt personnummer vara 10 siffor långt utan några spaces eller andra tecken");
                continue;
            }
            //Detta kan se lite kryptiskt ut, men säg att vi har ett samordningsnummer: 8603674055
            //Detta ser man igenom att dagen alltid är över 60, vilket betyder att siffra nummer 5 (position 4) är större än 5.
            //Det ni ser nedan sätter sam till true eller false baserat på logiken jag beskrev på raden över.
            boolean sam = (pn.charAt(4) - '0' > 5);
            //Med organisation gör vi nästan samma sak bara att vi kollar om månaden är över 20 istället.
            boolean org = (pn.charAt(2) - '0' > 1);
            //Här skickar vi in personnummret (pn) till våran algorithm vi skrev i verify funktionen ovanför, vi sparar sedan resultatet till en boolean.
            boolean passed = verify(pn);
            //Om personnummret var giltigt körs if-satsen nedan annars hoppar koden till else-blocket.
            if (passed) {
                //Personnummret var giltigt och nu måste vi bestämma oss om vilken typ av nummer det var.
                //om org är true betyder det att nummret var en organisationsnummer och vi berättar det för användaren.
                if (org) {
                    System.out.println("Detta är ett organisationsnummer och det är giltigt");
                    //Vi berättar också om vilken typ av organisation det är.
                    //Denna infon hämtar vi igenom att ta första siffran ur personnummret och hämtar stringen på den positionen i listan types.
                    System.out.println("Organisationen är en: " + types[digits.get(0)]);
                }
                //Om org inte är sant kollar vi om sam är sant istället och skriver ut den informationen till användaren.
                else if (sam) {
                    System.out.println("Detta är ett samordningsnummer och det är giltigt");
                }
                //Om både org & sam är satta till false betyder det att vi har ett personnummer och vi skriver ut relevant data.
                else {
                    //Vi börjar med att informera om att det är ett giltigt personnummer.
                    System.out.println("Ditt personnummer är giltigt!");
                    //Sedan kollar vi om 3dje siffran av dem sista 4 är jämn (med andra ord siffra 9, positon 8), om den är det betyder det att det är en kvinna, annars skriver vi att det är en man
                    if (digits.get(8) % 2 == 0) {
                        System.out.println("Du är en kvinna!");
                    } else {
                        System.out.println("Du är en man!");
                    }
                    //För att skriva ut personens födelsedatum tar vi helt enkelt dem första 6 siffrorna ur användarens input och skickar tillbaka ut.
                    System.out.println("Du föddes: " + pn.substring(0, 6));
                }
            }
            //Om personnummret inte var giltigt skriver vi ut det och programmet hoppar automatiskt upp till början och låter användaren testa ett nytt personnummer.
            else {
                System.out.println("Ditt person/organisations/samordnings-nummer var ogiltigt.");
            }

        }
    }
}

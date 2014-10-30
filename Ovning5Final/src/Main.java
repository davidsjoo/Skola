import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        while (true) {
            HashMap<String, String> lexikon;
            lexikon = new HashMap<String, String>();
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = null;

            try {
                sc2 = new Scanner(new File("lexikon.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (sc2.hasNextLine()) {
                Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String s = s2.next();
                    lexikon.put(s, s2.next());
                }
            }

            System.out.print("Skriv ett svenskt ord eller exit om du vill avsluta: ");
            String ord1 = sc.next();
            String ord = ord1.toLowerCase();

            if (ord.equals("exit") || ord.equals("Exit")) {
                return;
            }

            if (lexikon.get(ord) == null) {
                System.out.println(ord + " finns inte i mitt lexikon :(");
            } else {
                System.out.println(ord + " på engelska är " + lexikon.get(ord));
            }
        }
    }
}

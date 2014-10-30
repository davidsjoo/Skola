import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testTest() throws Exception {

        assertTrue(Main.test("8806092923")); //Giltigt personnummer
        assertFalse(Main.test("8806"));
        assertFalse(Main.test("asd"));
        assertFalse(Main.test("8813092923")); //Persnr med 13 månader
        assertTrue(Main.test("5563986719")); //Byggnadsfirma Sjöö orgnr
        assertTrue((Main.test("8020028711"))); //Röda korsets orgnr


    }
}
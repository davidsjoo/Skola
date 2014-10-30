import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void testVerify() throws Exception {
        assertTrue(Main.verify("9411257828")); //Giltigt
        assertTrue(Main.verify("8305187893")); //Giltigt
        assertFalse(Main.verify("9461257828")); //Ogiltigt
        assertFalse(Main.verify("8325187893")); //Ogiltigt
        assertFalse(Main.verify("Nope")); //Ogilitigt
        assertFalse(Main.verify("123")); //Ogiltigt
        assertFalse(Main.verify("12345678910")); //Ogiltigt
        assertFalse(Main.verify("Fail me")); //Ogiltigt
        assertTrue(Main.verify("8603674055")); //Giltigt samordningsnummer
        assertTrue(Main.verify("5569670960")); //Giltigt organisationsnummer
    }
}
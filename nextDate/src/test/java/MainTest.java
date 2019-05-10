import org.junit.Test;
import org.mockito.Mockito;
import static  org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class MainTest {

    @Test
    public void nextdate() {
        try {
            Main.NextDate(1, 1, 0);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid year"
            );
        }


        try {
            Main.NextDate(0, 1, 1);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid month"
            );
        }

        try {
            Main.NextDate(13, 1, 1);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid month"
            );
        }

        try {
            Main.NextDate(1, 0, 1);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid day"
            );
        }
        try {
            Main.NextDate(1, 32, 1);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid day"
            );
        }

       assertEquals(Main.NextDate(2,28,1600),"2/29/1600");

        assertEquals(Main.NextDate(2,28,2100),"3/1/2100");

        assertEquals(Main.NextDate(2,14,114514),"2/15/114514");

        assertEquals(Main.NextDate(12,31,2004),"1/1/2005");

        assertEquals(Main.NextDate(12,31,-1),"1/1/1");

        assertEquals(Main.NextDate(3,31,-16400),"4/1/-16400");

        assertEquals(Main.NextDate(2,14,-300),"2/15/-300");

        assertEquals(Main.NextDate(6,21,-4),"6/22/-4");

        Date test_mk=mock(Date.class);
        Mockito.when(test_mk.printDate()).thenReturn("mmp").thenReturn("asd");
        assertEquals(test_mk.printDate(),"mmp");
        assertEquals(test_mk.printDate(),"asd");







    }
}
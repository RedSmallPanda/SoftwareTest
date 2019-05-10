import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private Main main;
    @Test
    public void nextdate() {
        try {
            main.Nextdate(1, 1, 0);
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
            main.Nextdate(0, 1, 1);
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
            main.Nextdate(13, 1, 1);
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
            main.Nextdate(1, 0, 1);
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
            main.Nextdate(1, 32, 1);
            fail();
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid day"
            );
        }

       assertEquals(main.Nextdate(2,28,1600),"2/29/1600");

        assertEquals(main.Nextdate(2,28,2100),"3/1/2100");

        assertEquals(main.Nextdate(2,14,114514),"2/15/114514");

        assertEquals(main.Nextdate(12,31,2004),"1/1/2005");

        assertEquals(main.Nextdate(12,31,-1),"1/1/1");

        assertEquals(main.Nextdate(3,31,-16400),"4/1/-16400");

        assertEquals(main.Nextdate(2,14,-300),"2/15/-300");

        assertEquals(main.Nextdate(6,21,-4),"6/22/-4");






    }
}
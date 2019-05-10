import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {

    private Year year;

    @Before
    public void setUp() throws Exception {
        year = new Year(2019);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setYear() {
        year.setYear(2000);
        assertEquals(year.getYear(), 2000);
        try {
            year.setYear(0);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid year"
            );
        }
    }

    @Test
    public void getYear() {
        assertEquals(year.getYear(), 2019);
    }

    @Test
    public void increment() {
        year.increment();
        assertEquals(year.getYear(), 2020);
        year.setYear(-1);
        year.increment();
        assertEquals(year.getYear(), 1);
    }

    @Test
    public void isLeap() {
        assertFalse(year.isLeap());
        year.setYear(2016);
        assertTrue(year.isLeap());
        year.setYear(1900);
        assertFalse(year.isLeap());
        year.setYear(2000);
        assertTrue(year.isLeap());
        year.setYear(-5);
        assertTrue(year.isLeap());
        year.setYear(-101);
        assertFalse(year.isLeap());
        year.setYear(-401);
        assertTrue(year.isLeap());
        year.setYear(-2);
        assertFalse(year.isLeap());
    }

    @Test
    public void isValid() {
        assertTrue(year.isValid());
        year.setCurrentPos(0);
        assertFalse(year.isValid());
    }

    @Test
    public void equals1() {
        assertEquals(year, new Year(2019));
        assertNotEquals(year, new Year(2020));
        assertNotEquals(year, new Object());
    }
}
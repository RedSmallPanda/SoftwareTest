import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonthTest {

    private Month month;
    private Year year;

    @Before
    public void setUp() throws Exception {
        year = new Year(2019);
        month = new Month(5, year);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setMonth() {
        assertEquals(month.getMonth(), 5);
        try {
            month.setMonth(13, year);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid month");
        }
    }

    @Test
    public void getMonth() {
        assertEquals(month.getMonth(), 5);
    }

    @Test
    public void getMonthSize() {
        assertEquals(month.getMonthSize(), 31);
        year.setYear(2020);
        month.setMonth(2, year);
        assertEquals(month.getMonthSize(), 29);

    }

    @Test
    public void increment() {
        month = new Month(12, new Year(2019));
        assertEquals(month.increment(), false);
        month = new Month(1, new Year(2019));
        assertEquals(month.increment(), true);
    }

    @Test
    public void isValid() {
        assertEquals(month.isValid(), true);
    }

    @Test
    public void equals() {
        assertTrue(month.equals(new Month(5, year)));
        assertTrue(!month.equals(new Month(7, year)));
    }

    @Test
    public void setCurrentPos() {
        assertEquals(month.getMonth(), 5);
        month.setCurrentPos(13);
        assertEquals(month.getMonth(), 13);
    }

    @Test
    public void getCurrentPos() {
        assertEquals(month.getCurrentPos(), 5);
        month.setCurrentPos(13);
        assertEquals(month.getCurrentPos(), 13);
    }

    @Test
    public void increment1() {

    }

    @Test
    public void isValid1() {
    }
}
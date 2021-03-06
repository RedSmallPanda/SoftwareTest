import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MonthTest {

    private Month month;
    private Year year;

    @Before
    public void setUp() throws Exception {
        year = mock(Year.class);
        when(year.isValid()).thenReturn(true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setMonth() {
        // case 1: set valid
        month = new Month(4, year);
        month.setMonth(5, year);
        assertEquals(month.getMonth(), 5);
        // case 2: set not valid
        try {
            month = new Month(4, year);
            when(month.isValid()).thenReturn(false);
            month.setMonth(13, year);
            // can't reach here
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid month");
        }
    }

    @Test
    public void getMonth() {
        // case 1
        month = new Month(5, year);
        assertEquals(month.getMonth(), 5);
    }

    @Test
    public void getMonthSize() {
        // case 1
        when(year.isLeap()).thenReturn(false);
        month = new Month(2, year);
        assertEquals(month.getMonthSize(), 28);
        // case 2
        when(year.isLeap()).thenReturn(true);
        month = new Month(2, year);
        assertEquals(month.getMonthSize(), 29);

    }

    @Test
    public void increment() {
        // case 1
        month = new Month(1, year);
        assertTrue(month.increment());
        assertEquals(month.getMonth(), 2);
        // case 2
        month = new Month(12, year);
        assertFalse(month.increment());
    }

    @Test
    public void isValid() {
        // case 1
        month = new Month(5, year);
        assertTrue(month.isValid());
        // case 2
        try {
            month = new Month(5, year);
            month.setMonth(5, null);
            fail();
        } catch (Exception e) {
            assertFalse(month.isValid());
        }
        // case 3
        try {
            month = new Month(5, year);
            month.setMonth(0, year);
        } catch (Exception e) {
            assertFalse(month.isValid());
        }
        // case 4
        try {
            month = new Month(5, year);
            month.setMonth(13, year);
        } catch (Exception e) {
            assertFalse(month.isValid());
        }
        // case 5
        try {
            when(year.isValid()).thenReturn(false);
            month = new Month(5, year);
        } catch (Exception e) {
            assertFalse(month.isValid());
        }
    }

    @Test
    public void equals() {
        month = new Month(5, year);
        assertEquals(month, new Month(5, year));
        assertNotEquals(month, new Month(7, year));
        assertNotEquals(month, new Month(5, new Year(2020)));
        assertNotEquals(month, new Object());
    }

    @Test
    public void setCurrentPos() {
        month = new Month(5, year);
        assertEquals(month.getMonth(), 5);
        month.setCurrentPos(13);
        assertEquals(month.getMonth(), 13);
    }

    @Test
    public void getCurrentPos() {
        month = new Month(5, year);
        assertEquals(month.getCurrentPos(), 5);
        month.setCurrentPos(13);
        assertEquals(month.getCurrentPos(), 13);
    }

}
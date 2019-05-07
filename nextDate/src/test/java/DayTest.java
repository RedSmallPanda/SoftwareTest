import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayTest {

    private Day day;


    @Test
    public void increment() {
        day = new Day(1, new Month(1, new Year(1)));
        assertTrue(day.increment());
        assertEquals(day, new Day(2, new Month(1, new Year(1))));
        day = new Day(29, new Month(2, new Year(4)));
        assertFalse(day.increment());
    }

    @Test
    public void setDay() {
        Month month = new Month(1, new Year(1));
        day = new Day(1, month);
        day.setDay(5, month);
        assertEquals(day, new Day(5, month));
        try {
            day.setDay(32, month);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(
                    e.toString(),
                    "java.lang.IllegalArgumentException: Not a valid day"
            );
        }
    }

    @Test
    public void getDay() {
        Month month = new Month(1, new Year(1));
        day = new Day(1, month);
        assertEquals(day.getDay(), 1);
    }

    @Test
    public void isValid() {
        Month month = new Month(1, new Year(1));
        day = new Day(1, month);
        assertTrue(day.isValid());
        day.setCurrentPos(32);
        assertFalse(day.isValid());
    }

    @Test
    public void equals1() {
        Month month = new Month(1, new Year(1));
        day = new Day(1, month);
        assertEquals(day, new Day(1, month));
        assertNotEquals(day, new Object());
    }
}
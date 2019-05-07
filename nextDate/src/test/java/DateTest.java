import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    private Year y;
    private Month m;
    private Day d;
    private Date date;

    @Before
    public void setUp() throws Exception {
        y = new Year(2010);
        m = new Month(2,y);
        d = new Day(28,m);
        date = new Date(m.getMonth(),d.getDay(),y.getYear());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void increment() {
        assertEquals(date.increment(),"3/1/2010");
        assertEquals((new Date(12,31,2010)).increment(),"1/1/2011");
    }

    @Test
    public void printDate() {
        assertEquals(date.printDate(),"2/28/2010");
    }

    @Test
    public void getDay() {
        assertEquals(date.getDay(),d);
    }

    @Test
    public void getMonth() {
        assertEquals(date.getMonth(),m);
    }

    @Test
    public void getYear() {
        assertEquals(date.getYear(),y);
    }

    @Test
    public void equals1() {
        assertEquals(
                new Date(3,21,2010),
                new Date(3,21,2010)
        );
        assertNotEquals(
                new Date(3,21,2010),
                new Date(3,22,2010)
        );
    }

    @Test
    public void toString1() {
        assertEquals(date.toString(),"2/28/2010");
    }
}
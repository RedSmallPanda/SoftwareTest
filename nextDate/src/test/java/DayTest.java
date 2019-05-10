import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static  org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class DayTest {

    private Day day;


    @Test
    public void increment() {
        Month month=mock(Month.class);
        Mockito.when(month.getMonthSize()).thenReturn(30).thenReturn(29);
        Mockito.when(month.isValid()).thenReturn(true);
        day = new Day(1, month);
        assertTrue(day.increment());
        assertEquals(day, new Day(2, month));
        day = new Day(29, month);
        assertFalse(day.increment());
        day = new Day(29, month);
        assertFalse(day.increment());
    }

    @Test
    public void setDay() {
        Month month = mock(Month.class);
        Mockito.when(month.getMonthSize()).thenReturn(30);
        Mockito.when(month.isValid()).thenReturn(true);

        Day realday=new Day(10,new Month(1,new Year(1) ));
        //使用spy函数 对同一个类下的isvalid方法打桩
        Day testday=spy(realday);
        Mockito.when(testday.isValid()).thenReturn(true).thenReturn(false);

       testday.setDay(5, month);
       assertEquals(testday.getDay(), 5);
        try {
            testday.setDay(32, month);
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
        Month month=mock(Month.class);
        when(month.isValid()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false).thenReturn(true);
        when(month.getMonthSize()).thenReturn(30);

        day = new Day(1, month);
        assertTrue(day.isValid());

        day.setCurrentPos(-1);
        assertFalse(day.isValid());

        day.setCurrentPos(32);
        assertFalse(day.isValid());

        assertFalse(day.isValid());

        //m=null
        try{
            day.setDay(1,null);
            fail();
        }
        catch (Exception e){
            assertFalse(day.isValid());
        }

    }

    @Test
    public void equals() {
        Month month = new Month(1, new Year(1));
        day = new Day(1, month);
        assertEquals(day, new Day(1, month));
        assertNotEquals(day,new Day(1,new Month(2,new Year(1))));
        assertNotEquals(day, new Object());
    }
}
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class DateTest {
    private Year y;
    private Month m;
    private Day d;
    private Date date;

    public Date mockMock(int year, int month, int day, boolean yLeap, boolean mInc, int mSize,
                         boolean mIsValid, boolean dInc, boolean dIsValid) {
        Year mockYear = Mockito.mock(Year.class);
        when(mockYear.getYear()).thenReturn(year);
        when(mockYear.increment()).thenReturn(true);
        when(mockYear.isLeap()).thenReturn(yLeap);
        when(mockYear.isValid()).thenReturn(true);
        y = mockYear;

        Month mockMonth = Mockito.mock(Month.class);
        when(mockMonth.getMonth()).thenReturn(month);
        when(mockMonth.increment()).thenReturn(mInc);
        when(mockMonth.getMonthSize()).thenReturn(mSize);
        when(mockMonth.isValid()).thenReturn(mIsValid);
        m = mockMonth;

        Day mockDay = Mockito.mock(Day.class);
        when(mockDay.getDay()).thenReturn(day);
        when(mockDay.increment()).thenReturn(dInc);
        when(mockDay.isValid()).thenReturn(dIsValid);
        d = mockDay;

        return new Date(mockMonth, mockDay, mockYear);
    }

    @Before
    public void setUp() throws Exception {
//        y = new Year(2010);
//        m = new Month(2,y);
//        d = new Day(28,m);


        date = mockMock(2010, 2, 28, false, true, 28, true, false, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void increment() {
        date = mockMock(2010, 2, 28, false, true, 28, true, false, true);
        date.increment();
        verify(d).setDay(1, m);

        date = mockMock(2010, 12, 31, false, false, 31, true, false, true);
        date.increment();
        verify(m).setMonth(1, y);
        verify(d).setDay(1, m);

        date = mockMock(2010, 2, 20, false, true, 28, true, true, true);
        date.increment();
        verify(m, never()).increment();
    }

    @Test
    public void printDate() {
        assertEquals(date.printDate(), "2/28/2010");
    }

    @Test
    public void getDay() {
        assertEquals(date.getDay().getDay(), 28);
    }

    @Test
    public void getMonth() {
        assertEquals(date.getMonth().getMonth(), 2);
    }

    @Test
    public void getYear() {
        assertEquals(date.getYear().getYear(), 2010);
    }

    @Test
    public void equals1() {
        Year y1 = new Year(2010);
        Month m1 = new Month(3, y1);
        Day d1 = new Day(21, m1);

        Year y2 = new Year(2010);
        Month m2 = new Month(3, y2);
        Day d2 = new Day(22, m2);

        Year y3 = new Year(2010);
        Month m3 = new Month(4, y3);
        Day d3 = new Day(21, m3);

        Year y4 = new Year(2011);
        Month m4 = new Month(3, y4);
        Day d4 = new Day(21, m4);
        assertEquals(
                new Date(m1, d1, y1),
                new Date(m1, d1, y1)
        );
        assertNotEquals(
                new Date(m1, d1, y1),
                new Date(m2, d2, y2)
        );
        assertNotEquals(
                new Date(m1, d1, y1),
                new Date(m3, d3, y3)
        );
        assertNotEquals(
                new Date(m1, d1, y1),
                new Date(m4, d4, y4)
        );
        assertNotEquals(
                new Date(m1, d1, y1),
                new Object()
        );

    }

    @Test
    public void toString1() {
        assertEquals(date.toString(), "2/28/2010");
    }
}
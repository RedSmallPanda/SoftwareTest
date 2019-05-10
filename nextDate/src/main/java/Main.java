public class Main {

    public static String nextDate(int month, int day, int year) {
        Year y = new Year(year);
        Month m = new Month(month, y);
        Day d = new Day(day, m);
        Date date = new Date(m, d, y);
        date.increment();
        return date.toString();
    }

}

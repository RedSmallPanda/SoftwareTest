public class Main {


	public static String NextDate(int month, int day, int year) {
	    Date d = new Date(month,day,year);
	    Date dd = new Date(d.getMonth().getCurrentPos(), d.getDay().getCurrentPos(), d.getYear().getCurrentPos());
        dd.increment();
        return dd.toString();
    }

}

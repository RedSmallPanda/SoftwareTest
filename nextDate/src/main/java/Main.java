public class Main {

	public static void main(String[] args) {
	    Date d = new Date(2,29,2016);
	    Date dd = new Date(d.getMonth().getCurrentPos(), d.getDay().getCurrentPos(), d.getYear().getCurrentPos());
        dd.increment();
        System.out.println(dd.toString());
    }

}

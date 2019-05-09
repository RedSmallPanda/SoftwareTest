public class Main {

    public static void main(String[]args){
        Date d = new Date(12,31,-1);
        d.increment();
        System.out.println(d.toString());
    }
	public static String Nextdate(int month,int day,int year) {
	    Date d = new Date(month,day,year);
	    Date dd = new Date(d.getMonth().getCurrentPos(), d.getDay().getCurrentPos(), d.getYear().getCurrentPos());
        dd.increment();
        return dd.toString();
    }

}

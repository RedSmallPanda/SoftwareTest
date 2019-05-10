public class Main {

    public static void main(String[]args){
        Year y=new Year(-1);
        Month m=new Month(12,y);
        Day d=new Day(31,m);
        Date date = new Date(m,d,y);
        date.increment();
        System.out.println(date.toString());
    }
	public static String Nextdate(int month,int day,int year) {
        Year y=new Year(year);
        Month m=new Month(month,y);
        Day d=new Day(day,m);
	    Date date = new Date(m,d,y);
	    //Date dd = new Date(date.getMonth().getCurrentPos(), date.getDay().getCurrentPos(), date.getYear().getCurrentPos());
        date.increment();
        return date.toString();
    }

}

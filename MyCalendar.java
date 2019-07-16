import java.util.GregorianCalendar;
import java.io.Serializable;
/**
 * @since 2019/07/16
 * @author Viberti Kim
 * @version 0.1
 * This class adds some handy method to the class Calendar
 */
public class MyCalendar extends GregorianCalendar implements Serializable {
    //Static methods--------------------------------------------------------------------------------------------------------------------------
    public static MyCalendar getCalendar(String date) throws TimeException {
        int year = 0, month = 0, day = 0;

        if(date.matches("[0-9]+/[0-9]+/[0-9]+")) {
            String[] arr = date.split("/");

            year = Integer.parseInt(arr[0]);
            month = Integer.parseInt(arr[1]) - 1; //0 index system
            day = Integer.parseInt(arr[2]);

        } else {throw new TimeException("Eccezione, la data inserita non segue il formato 'yyyy/mm/dd'");}

        return new MyCalendar(year, month, day);
    }

    private static MyCalendar getCalendar(String date, int offset, int field) throws TimeException {
        MyCalendar res = null;

        try{
            res = getCalendar(date);
        } catch(TimeException e) {throw e;}

        res.add(field, offset);

        return res;
    }
    //Constructors----------------------------------------------------------------------------------------------------------------------------
    private MyCalendar(int year, int month, int day) {
        super(year, month, day);
    }
    //set() & get()---------------------------------------------------------------------------------------------------------------------------
    public int getYEAR() {return get(YEAR);}

    public int getMONTH() {return get(MONTH) + 1;} // 0 based index system

    public int get_DAY_OF_MONTH() {return get(DAY_OF_MONTH);}

    public String get_DAY_OF_WEEK() {
        int day = get(DAY_OF_WEEK);
        String res = "";

        if(day == 2) {
            res = "Lunedi";
        } else if(day == 3) {
            res = "Martedi";
        } else if(day == 4) {
            res = "Mercoledi";
        } else if(day == 5) {
            res = "Giovedi";
        } else if(day == 6) {
            res = "Venerdi";
        } else if(day == 7) {
            res = "Sabato";
        } else if(day == 1) {
            res = "Domenica";
        }

        return res;
    }
    //Methods---------------------------------------------------------------------------------------------------------------------------------
    public MyCalendar get_last_day_of_week() throws TimeException {
        MyCalendar res = null;
        try {
            res = getCalendar(toString());
        } catch(TimeException e) {throw e;}

        while(res.get(res.DAY_OF_WEEK) != res.SUNDAY) {
            res.add(res.DAY_OF_MONTH, 1);
        }

        return res;
    }
    //Utility---------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "" + getYEAR() + "/" + getMONTH() + "/" + get_DAY_OF_MONTH();
    }
}

class MyCalendarDemo {
    public static void test01() throws Exception {
        MyCalendar cal = null, cal2 = null;
        try {
            cal = MyCalendar.getCalendar("2019/12/21");

            System.out.println("First calendar created in date: " + cal.toString() + " ed e' " + cal.get_DAY_OF_WEEK());

            cal2 = cal.get_last_day_of_week();

            System.out.println("Second calendar created, end of week in date: " + cal2.toString() + " ed e' " + cal2.get_DAY_OF_WEEK());
        } catch(Exception e) {throw e;}
    }

    public static void main(String[] args) {
        try {
            test01();
        }catch(Exception e) {System.out.println(e.getMessage());}
    }
}

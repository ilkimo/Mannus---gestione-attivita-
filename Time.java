import java.io.Serializable;
/**
 * Virtual representation of time (hours:minutes) seen as 2 couple
 *  of digits separated by :
 */
public class Time implements Comparable, Serializable {
    private int time_in_minutes;
    //Constructors---------------------------------------------------------------------------------------
    public Time(String str) throws TimeException {
        try {
            time_in_minutes = Time.convert_to_number_of_minutes(str);
        } catch(TimeException e) {throw e;}
    }
    //set() & get()--------------------------------------------------------------------------------------
    public int getTime() {return time_in_minutes;}
    //Methods--------------------------------------------------------------------------------------------
    public static boolean isCorrect(String time) {
        boolean res = false;

        if(time.matches("[0-9]{2}:[0-9]{2}")) {
            String[] arr = time.split(":");
            if(Integer.parseInt(arr[0]) <= 23 && Integer.parseInt(arr[1]) <= 59) {
                res = true;
            }
        }

        return res;
    }
    //Utility--------------------------------------------------------------------------------------------
    public static int convert_to_number_of_minutes(String str) throws TimeException {
        if(!isCorrect(str))
            throw new TimeException("Eccezione: l'ora inserita non e' valida, utilizzare formato hh:mnt");

        String[] arr = str.split(":");

        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    @Override
    public int compareTo(Object other) {
        int res = -1;

        if(other instanceof Time) {
            res = time_in_minutes - ((Time) other).getTime();
        }

        return res;
    }

    @Override
    public String toString() {
        return "" + time_in_minutes;
    }
    //---------------------------------------------------------------------------------------------------
}

class TimeDemo {
    public static void test01() {
        String str = "12:40";
        String[] arr = str.split(":");

        for(int i = 0; i < arr.length; ++i) {
            System.out.println("[" + i  + "]: " + arr[i]);
        }
    }

    public static void test02() {
        Time t[] = null;
        try {
            t = new Time[]{
                    new Time("00:00"),
                    new Time("00:30"),
                    new Time("01:00"),
                    new Time("01:30"),
                    new Time("02:00"),
                    new Time("02:30"),
                    new Time("03:00"),
                    new Time("03:30"),
                    new Time("04:00"),
                    new Time("04:30"),
                    new Time("05:00"),
                    new Time("05:30"),
                          };
        } catch(Exception e) {System.out.println(e.getMessage());}

        for(int i = 0; i < t.length; ++i) {
            System.out.println("output: " + t[i].toString());
        }
    }

    public static void test03() throws Exception {
        Time t = null;

        try {
            t = new Time("23:60");
        } catch(Exception e) {throw e;}

        System.out.println("ok!");
    }

    public static void test04() throws Exception {
        Time t1 = null, t2 = null, t3 = null;

        try {
            t1 = new Time("12:30");
            t2 = new Time("12:30");
            t3 = new Time("19:30");
        } catch(Exception e) {throw e;}

        System.out.println((t1.compareTo(t2) == 0) &&
                           (t1.compareTo(t3) < 0) &&
                           (t3.compareTo(t1) > 0));
    }

    public static void main(String[] args) {
        //test01();

        //test02();

        /*try {
            test03();
        } catch(Exception e) {System.out.println(e.getMessage());}*/

        try {test04();} catch(Exception e) {System.out.println(e.getMessage());}
    }
}

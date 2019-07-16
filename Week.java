import java.io.Serializable;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Week implements Serializable {
    private Children kids;
    private MyCalendar weekStart;
    private ActivityList actList;
    //Constructors-----------------------------------------------------------------------------------------------------------------------------------
    public Week(String date) throws TimeException {
        kids = null;
        actList = null;
        try {
            weekStart = MyCalendar.getCalendar(date);
        } catch(TimeException e) {throw e;}
    }

    public Week(Children kids, String date) throws TimeException {
        this.kids = kids;
        actList = null;
        try {
            weekStart = MyCalendar.getCalendar(date);
        } catch(TimeException e) {throw e;}
    }

    public Week(ActivityList actList, String date) throws TimeException {
        kids = null;
        this.actList = actList;
        try {
            weekStart = MyCalendar.getCalendar(date);
        } catch(TimeException e) {throw e;}
    }

    public Week(Children kids, ActivityList actList, String date) throws TimeException {
        this.kids = kids;
        this.actList = actList;
        try {
            weekStart = MyCalendar.getCalendar(date);
        } catch(TimeException e) {throw e;}
    }
    //set() && get()---------------------------------------------------------------------------------------------------------------------------------
    public Children getChildren() {return kids;}

    public ActivityList getActivityList() {return actList;}
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    public void add_kid(Kid k) throws AddException {
        if(kids == null)
            kids = new Children();

        try {
            kids.add(k);
        } catch(AddException e) {throw e;}
    }

    public void remove_kid(Kid k) {
        kids.remove(k);
        //maybe add a refresher (refreshes if group calculations have already been done)
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String res = "Settimana [";
        //Date_____________________________________________________________
        if(weekStart != null) {
            res += weekStart.toString();
            res += "-";
            try {
                res += weekStart.get_last_day_of_week().toString();
            } catch(TimeException e) {} //should never occur, probably the best choice should be to make log file
            res += "]\n\n";
        }
        //Activities_______________________________________________________
        res += "Attivita': \n";
        if(actList != null) {
            res += actList.toString() + "\n\n";
        }
        //Kids_____________________________________________________________
        res += "Iscritti: \n";
        if(kids != null)
            res += kids.toString() + "\n\n";
        //_________________________________________________________________
        return res;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------
}

class WeekDemo {
    public static void test01() {

    }

    public static void main(String[] args) {
        test01();
    }
}

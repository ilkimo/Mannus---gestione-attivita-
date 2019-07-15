import java.util.Calendar;
import java.io.Serializable;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 * Class invariants:
 *  1) nWeeks always shows how many weeks there are in [] weekList
 */
public abstract class MannusSeason implements Serializable { //istances of this class could be attributes of a larger class "MannusClub"
    private int year, nWeeks;
    /**
     * Holds instances of past/present/future weeks saved so far
     */
    private Week[] weekList;
    //-------------------------------------------------------------------------------------------------------------------------------
    public MannusSeason(int year) {
        this.year = year;
        nWeeks = 0;
        weekList = null;
    }
    //set() & get()------------------------------------------------------------------------------------------------------------------
    private void setYear(int year) throws MannusSeasonException {
        if(year <= 2018)
            throw new MannusSeasonException("Eccezione, anno non previsto, inserire anno > 2018");
        this.year = year;
    }

    private void setNWeeks(int n) throws MannusSeasonException {
        if(n < 0 || n > 100)
            throw new MannusSeasonException("Eccezione, numero di settimane non previsto, inserire un numero compreso fra 0 e 100");
        nWeeks = n;
    }

    private void setWeekList(Week[] list) {
        weekList = list;
    }

    //Methods------------------------------------------------------------------------------------------------------------------------
    private boolean empty() {return nWeeks == 0;}

    /**
     * To call only when (weekList != null)
     */
    private boolean full() {return nWeeks == weekList.length;}

    public void addWeek(Week w) {
        if(empty()) {
            weekList = new Week[] {w};
        } else {
            if(full()) {
                Week[] tmp = weekList;
                weekList = new Week[weekList.length * 2];

                for(int i = 0; i < nWeeks; ++i) {
                    weekList[i] = tmp[i];
                }
            }
            weekList[nWeeks] = w;
        }

        ++nWeeks;
    }

    //Utility------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String res = "\u001B[35m" + "" + year + ":\n\n" + "\u001B[0m";

        for(int i = 0; i < nWeeks && weekList != null && weekList[i] != null; ++i) {
            res += weekList[i].toString() + "\n";

            if(i < nWeeks - 1) {
                res += "\n";
            }
        }
        return res;
    }
}

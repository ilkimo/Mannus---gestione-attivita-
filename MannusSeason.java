import java.util.Calendar;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public abstract class MannusSeason { //istances of this class could be attributes of a larger class "MannusClub"
    private String year;
    private int nWeeks;
    /**
     * Holds instances of past/present/future weeks saved so far
     */
    private Week[] weekList;
    //-------------------------------------------------------------------------------------------------------------------------------
    public MannusSeason() {}
    //-------------------------------------------------------------------------------------------------------------------------------
    public void setYear(String year) throws MannusSeasonException {
        int y = 0;

        try {y = Integer.parseInt(year);}
        catch(Exception e) {throw new MannusSeasonException(e.getMessage());}

        if(y <= 0)
            throw new MannusSeasonException("Eccezione, anno non previsto, inserire anno > 0");
        this.year = "" + y;
    }

    public void setNWeeks(int n) throws MannusSeasonException {
        if(n < 0 || n > 100)
            throw new MannusSeasonException("Eccezione, numero di settimane non previsto, inserire un numero compreso fra 0 e 100");
        nWeeks = n;
    }

    public void setWeekList(Week[] list) {
        weekList = list;
    }
    //-------------------------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------------------------------------
}

import java.util.Calendar;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public abstract class MannusSeason { //istances of this class could be attributes of a larger class "MannusClub"
    private int year;
    /**
     * Holds information about the first Monday of the Season
     */
    private Calendar firstWeek;
    /**
     * Holds information about the last Monday of the Season
     */
    private Calendar lastWeek;
    private int nWeeks;
    /**
     * Holds instances of past/present/future weeks saved so far
     */
    private Week[] weekList;
}

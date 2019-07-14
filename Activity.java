import java.io.Serializable;
 /**
  * @author Kim Viberti <vibertikim@yahoo.it>
  * @version 0.0.1
  * @since 0.0.1
  * Class invariant: each activity name has to be unique, the time for the activity has to be a multiple of 15mnts
  */
public class Activity implements Serializable {
    private String name;
    /**
     * Minimum number of kids in each group
     */
    private int minGroups;
    /**
     * Maximum number of kids in each group
     */
    private int maxGroups;
    /**
     * Number of times this activity occours in the week
     */
    private int nTimes;
    /**
     * Time (expressed in minutes) for each group
     */
    private int timeActivity;
    //Constructors------------------------------------------------------------------------------------------------------------------
    public Activity(String name) {
        this.name = name;
    }
    //set() & get()-----------------------------------------------------------------------------------------------------------------
    public String getName() {return name;}

    /**
     * Ask first for maxGroups to avoid stupid exceptions being throwed
     */
    public void setMinGroups(int n) throws ActivityException {
        if(n > getMaxGroups())
            throw new ActivityException("Eccezione: numero minimo di partecipanti > numero massimo di partecipanti");
        minGroups = n;
    }

    public int getMinGroups() {return minGroups;}

    public void setMaxGroups(int n) throws ActivityException {
        if(n < 0)
            throw new ActivityException("Eccezione: numero massimo di partecipanti non puo' essere < 0");
        maxGroups = n;
    }

    public int getMaxGroups() {return maxGroups;}

    public void setTimeActivity(int minutes) throws ActivityException {
        if(minutes % 15 != 0)
            throw new ActivityException("Eccezione: la durata dell'attivita' deve essere un multiplo di 15 minuti");
        this.timeActivity = minutes;
    }
    //Methods-----------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object other) {
        return (other instanceof Activity && name.equalsIgnoreCase(((Activity)other).getName()));
    }
    //Utility-----------------------------------------------------------------------------------------------------------------------
    public String toString() {
        return name;
    }
    //------------------------------------------------------------------------------------------------------------------------------
}

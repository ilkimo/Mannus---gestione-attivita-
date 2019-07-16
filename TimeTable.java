import java.io.Serializable;
import java.util.Scanner; //only for test class

public class TimeTable implements Serializable {
    /**
     * Dimension (in minutes) of each unit
     */
    public static final int sensibility = 15;
    public static final int minutes_per_day = 24 * 60;
    public static final int nBlocks = minutes_per_day / sensibility; //RESULT HAS TO BE EXACT (NO DECIMAL CIFERS)

    private String[][] table;
    //Constructors---------------------------------------------------------------------------------------------------------------
    public TimeTable() {
        table = new String[7][nBlocks];

        for(int i = 0; i < 7; ++i) {
            for(int j = 0; j < nBlocks; ++j) {
                table[i][j] = "n";
            }
        }
    }
    //Methods--------------------------------------------------------------------------------------------------------------------
    public int getBlock(Time t) throws TimeTableException { //wrapper
        int res = 0;

        try {
            res = getBlock(t.getTime());
        } catch(TimeTableException e) {throw e;}

        return res;
    }

    public boolean has_activity(String flag) {
        boolean found = false;

        for(int i = 0 ; table != null && i < table.length && !found; ++i) {
            for(int j = 0; table[i] != null && j < table[i].length && !found; ++j) {
                if(table[i][j].equalsIgnoreCase(flag))
                    found = true;
            }
        }

        return found;
    }

    public int getBlock(int mnt) throws TimeTableException {
        if(mnt < 0 || mnt > minutes_per_day)
            throw new TimeTableException("Eccezione: orario inserito non valido --> " + mnt + " minuti");

        if(mnt == 0)
            return 0;
        else
            return (mnt - 1) / sensibility;
    }

    public boolean isFree(int day, int from_mnt, int to_mnt) throws TimeTableException {
        boolean res = true;
        int beginBlock, endBlock;

        if(!checkTime(from_mnt, to_mnt))
            throw new TimeTableException("Eccezione: orario inserito non valido");

        try {
            beginBlock = getBlock(from_mnt);
            endBlock = getBlock(from_mnt);
        } catch(TimeTableException e) {
            throw e;
        }

        for(int i = beginBlock; (i <= endBlock) && res; ++i) {
            if(!table[day][i].equalsIgnoreCase("n")) {
                res = false;
            }
        }

        return res;
    }

    /**
     * Checks if the times given are > 0, the first is <= the second, the second is <= max minutes in a day
     */
    private boolean checkTime(int from_mnt, int to_mnt) {
        return from_mnt > 0 && from_mnt <= to_mnt && to_mnt <=minutes_per_day;
    }

    private void overrideBlocks(String flag, int day, int from_mnt, int to_mnt) throws TimeTableException {
        int endBlock;
        try {
            endBlock = getBlock(to_mnt);

            for(int i = getBlock(from_mnt); i <= endBlock; ++i) { //may be < endBlock
                table[day][i] = flag;
            }
        } catch(TimeTableException e) {throw e;}
    }

    public void removeActivity(int day, int from_mnt, int to_mnt) throws TimeTableException {
        try {
            setActivity("n", day, from_mnt, to_mnt);
        } catch(TimeTableException e) {throw e;}
    }

    public void removeActivity(String flag) {
        for(int i = 0; i < 7 && table != null; ++i) {
            for(int j = 0; j < nBlocks && table[i] != null && j < table[i].length; ++j) {
                if(table[i][j].equalsIgnoreCase(flag))
                    table[i][j] = "n";
            }
        }
    }

    public boolean setActivity(String flag, int day, int from_mnt, int to_mnt) throws TimeTableException {
        boolean done = false;

        try {
            if(checkTime(from_mnt, to_mnt) && isFree(day, from_mnt, to_mnt)) {
                overrideBlocks(flag, day, from_mnt, to_mnt);

                done = true;
            }
        } catch(TimeTableException e) {throw e;}


        return done;
    }

    //Utility--------------------------------------------------------------------------------------------------------------------
    public static String getDay(int tableLine) {
        String str = "";
        switch(tableLine) {
            case 0:
                str = "Lunedi'";
                break;
            case 1:
                str = "Martedi'";
                break;
            case 2:
                str = "Mercoledi'";
                break;
            case 3:
                str = "Giovedi'";
                break;
            case 4:
                str = "Venerdi'";
                break;
            case 5:
                str = "Sabato'";
                break;
            case 6:
                str = "Domenica";
                break;
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i = 0; table != null && i < table.length; ++i) {
            for(int j = 0; table[i] != null && j < table[i].length; ++j) {
                if(!(i == 0 && j == 0)) {
                    str += ", ";
                }

                str += table[i][j];
            }
            str += "\n";
        }

        return str;
    }
    //---------------------------------------------------------------------------------------------------------------------------
}

class TimeTableDemo {
    public static void pause() {
        Scanner t = new Scanner(System.in);

        System.out.print("...enter to continue...");
        t.nextLine();
    }

    public static void test1() {
        TimeTable t = new TimeTable();
        System.out.print(t.toString());
    }

    public static void test2() {
        System.out.println(TimeTable.nBlocks);
    }

    public static void main(String[] agrs) {
        //test1();
        test2();
        pause();
    }
}

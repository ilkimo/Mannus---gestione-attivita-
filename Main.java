import javax.swing.JFrame;
import java.util.Scanner; //only for Test class

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Main {
    /**
     * Starts the application by opening it's frame
     */
    public static void main(String[] args) {
        JFrame mainFrame = new MannusFrame();
        mainFrame.paint(mainFrame.getGraphics());
        mainFrame.setVisible(true);
    }
}

class MainDemo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static Scanner t = new Scanner(System.in);
    //---------------------------------------------------------------------------------------------------------------------------------
    public static void pause() {
        System.out.print(ANSI_BLUE + "...enter to continue..." + ANSI_RESET);
        t.nextLine();
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public static void test001() throws Exception {
        MannusSeason estate2019 = new MannusSeason(2019);

        try {
            estate2019.addWeek(new Week("2019/07/15"));
            System.out.println("ecco " + estate2019.toString());
        } catch(Exception e) {throw e;}

        System.out.println("End test, no errors");
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        try {
            test001();
        } catch(Exception e) {System.out.println("Exception: " + e.getMessage() + e.getStackTrace());}
    }
}

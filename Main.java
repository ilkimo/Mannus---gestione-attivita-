import javax.swing.JFrame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel; //remove me
import java.util.Scanner;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Main {
    public static void pause() {
        Scanner t = new Scanner(System.in);
        System.out.println("...enter to continue...");
        t.nextLine();
    }

    public static String get_actual_date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate localDate = LocalDate.now();
        String res = dtf.format(localDate);
    	return res;
    }
    /**
     * Starts the application by creating an instance of AppCore
     */
    public static void main(String[] args) {
        AppCore app = null;
        try {
            app = new AppCore(get_actual_date());

        } catch(Error e) {
            JFrame f = new JFrame("Errore");
            f.setSize(500, 200);
            f.setResizable(false);
            f.add(new JLabel(e.getMessage()));
            f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
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

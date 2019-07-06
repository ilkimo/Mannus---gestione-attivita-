import java.io.File;
import java.util.Calendar;
import java.util.Scanner; //only for tests
/**
 * Stands ofr Directory Manager, this class controls the structure of files in wich saved data is stored
 *
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 2019-07-03
 */
public class DM {
    /**
     * Returns true if the directory is created, else returns false (directory already exists)
     */
    public static boolean createDir(String nameDir) {
        File f = new File(nameDir);
        return f.mkdir();
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    /**
     * dir_exists_already => need to overraid stored data in it, if you want to save
     */
    public static boolean dir_exists_already(String nameDir) {
        File f = new File(nameDir);
        boolean res = !createDir(f);

        if(!res)
            f.delete();

        return res;
    }

    private static boolean createDir(File dir) {
        return dir.mkdir();
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    /**
     * Returns the file ready to be written on
     */
    public static File get_file_ready_to_override(String year, Calendar mondayDate) {
        //String path_name = year + //quiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
        //devo creare un pathname corretto sapendo anno e data del lunedi, per poter gestire le cartelle
        return null;
    }
    //-------------------------------------------------------------------------------------------------------------------------------
}

class DMDemo {
    public static Scanner t = new Scanner(System.in);

    public static void pause() {
        System.out.print("...press enter to continue....");
        t.nextLine();
    }

    public static void main(String[] args) {
        System.out.println(DM.dir_exists_already("cancellami/1"));
        System.out.println(DM.createDir("cancellami/1")); // con / si creano le sub cartelle
        System.out.println(DM.dir_exists_already("cancellami/1"));
        //pause();


    }
}

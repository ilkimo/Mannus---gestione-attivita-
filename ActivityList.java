import java.io.Serializable;
import java.util.Scanner; //only for test class
/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */
public class ActivityList implements Serializable {
    private GenericNode<Activity> first;
    private int length;
    //Constructors-----------------------------------------------------------------------------------------------------------
    public ActivityList() {
        first = null;
        length = 0;
    }

    public ActivityList(GenericNode<Activity> node) {
        first = node;
        length = getLength();
    }
    //set() get()------------------------------------------------------------------------------------------------------------
    public int getLength() {
        GenericNode<Activity> tmp = first;
        int l = 0;

        while(tmp != null) {
            tmp = tmp.getNext();
            ++l;
        }

        return l;
    }
    //Methods----------------------------------------------------------------------------------------------------------------
    public void add(Activity att) {
        if(!already_exists(att)) {
            if(empty()) {
                first = new GenericNode<Activity> (att, null);
            } else {
                GenericNode<Activity> tmp = first;

                while(tmp.getNext() != null) {
                    tmp = tmp.getNext();
                }

                tmp.setNext(new GenericNode<Activity> (att, null));
            }

            ++length;
        }
    }

    public boolean empty() {return first == null;}

    public boolean already_exists(Activity att) {
        GenericNode<Activity> tmp = first;
        boolean found = false;

        while(tmp != null && !found) {
            if(tmp.getElem().equals(att))
                found = true;

            tmp = tmp.getNext();
        }

        return found;
    }

    public boolean remove(Activity att) {
        boolean removed = false;

        if(!empty()) {
            if(first.getElem().equals(att)) {
                first = first.getNext();
                removed = true;
            } else {
                GenericNode<Activity> tmp, tmp2 = first;
                tmp = tmp2.getNext();

                while(tmp != null && !removed) {
                    if(tmp.getElem().equals(att)) {
                        tmp2.setNext(tmp.getNext());

                        removed = true;
                    }

                    tmp2 = tmp;
                    tmp = tmp.getNext();
                }
            }
            --length;
        }

        return removed;
    }
    //Utility----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String res = "";
        GenericNode<Activity> tmp = first;

        while(tmp != null) {
            res += "<";
            res += tmp.getElem().toString();
            tmp = tmp.getNext();
            res += ">";

            if(tmp != null) {
                res += ", ";
            }
        }

        return res;
    }
    //-----------------------------------------------------------------------------------------------------------------------
}



/*class ActivityListDemo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void pause() {
        Scanner t = new Scanner(System.in);
        System.out.print(ANSI_BLUE + "...enter to continue..." + ANSI_RESET);
        t.nextLine();
    }

    public static void main(String[] args) {
        ActivityList list = new ActivityList();

        System.out.println(ANSI_GREEN + "1: empty = " + list.empty() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Calcio"));
        System.out.println(ANSI_GREEN + "2: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Tennis"));
        System.out.println(ANSI_GREEN + "3: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Tennis"));
        System.out.println(ANSI_GREEN + "4: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Calcio"));
        System.out.println(ANSI_GREEN + "5: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Canoa"));
        System.out.println(ANSI_GREEN + "6: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Tennis Doppio"));
        System.out.println(ANSI_GREEN + "7: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.add(new Activity("Ping pong"));
        System.out.println(ANSI_GREEN + "8: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.remove(new Activity("Calcio"));
        System.out.println(ANSI_GREEN + "9: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.remove(new Activity("Calcio"));
        System.out.println(ANSI_GREEN + "10: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.remove(new Activity("Tennis Doppio"));
        System.out.println(ANSI_GREEN + "11: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();

        list.remove(new Activity("Ping pong"));
        System.out.println(ANSI_GREEN + "12: length = " + list.getLength() + " " + list.toString() + ANSI_RESET);
        pause();
    }
}*/

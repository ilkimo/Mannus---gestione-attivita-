import java.io.Serializable;
import java.util.Scanner; //only for test class

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 * Class invariants:
 *  1) length tells how many Kids there are in the List, last Kid at list[length - 1]
 *  2) The list is in alfanumeric order
 */
public class Children implements Serializable {
    private Kid[] list;
    private int length;

    public Children() {
        list = new Kid[1];
        length = 0;
    }
    //set() && get() methods-----------------------------------------------------------------------------------------------------
    public Kid[] getList() {return list;}

    public int getLength() {return length;}

    public void setList(Kid[] list) {this.list = list;}

    public void setLength(int length) {this.length = length;}
    //other methods--------------------------------------------------------------------------------------------------------------
    private void subLength() throws ListException {
        if(!empty())
            --length;
        else
            throw new ListException("Error, it's not possible to remove other objects from an empty list");
    }

    public boolean empty() {return length == 0;}

    public boolean full() {return length == list.length;}
    //List manipulation----------------------------------------------------------------------------------------------------------
    private void insert(Kid x) throws AddException {
        int index = findInsertIndex(x, 0, length - 1);

        if(empty() || index == length) {
            list[length] = x;
        } else {
            if(index == -1) {
                throw new AddException("Error " + x.toString() + "is already in the list: " + this.toString());
            }

            Kid tmp = list[index], tmp2 = null;
            list[index] = x;
            if(length > index + 1) {
                for(int i = index + 1; i < length; ++i) {
                    tmp2 = list[i];
                    list[i] = tmp;
                    tmp = tmp2;
                }
            }
            list[length] = tmp;
        }
    }

    /**
     * Finds the right index in order to insert Kid x in the ordered list, returns -1 if x is already in the list
     */
    private int findInsertIndex(Kid x, int l,  int r) {
        if(l == r) {
            if(list[l].equals(x)) {
                return -1;
            } else {
                return (x.compareTo(list[l]) < 0) ? l : l + 1;
            }
        } else {
            if(x.compareTo(list[(l + r) / 2]) < 0) {
                return findInsertIndex(x, l, (l + r) / 2); //left half recursion
            } else if(x.compareTo(list[(l + r) / 2]) > 0) {
                return findInsertIndex(x, (l + r) / 2 + 1, r); //right half recursion
            } else {
                return -1; //if compareTo gives 0, the 2 objects are the same
            }
        }
    }

    public void add(Kid x) throws AddException {
        if(x != null) {
            if(empty()) {
                list[0] = x;
                ++length;
            } else {
                if(full()) {
                    Kid[] tmp = list;
                    list = new Kid[list.length * 2];

                    for(int i = 0; i < tmp.length; ++i) {
                        list[i] = tmp[i];
                    }
                }

                try{
                    insert(x);
                    ++length;
                } catch(AddException e) {throw e;}
            }
        }
    }

    /**
     * Applies binary search to kid[] list, retuns -1 if Kid x is not found, else returns its index location inside the array
     */
    private int findRemovingIndex(Kid x, int l, int r) {
        if(l == r) {
            if(list[l].equals(x)) {
                return l;
            } else {
                return -1;
            }
        } else {
            if(x.compareTo(list[(l + r) / 2]) < 0) {
                return findRemovingIndex(x, l, (l + r) / 2); //left half recursion
            } else if(x.compareTo(list[(l + r) / 2]) > 0) {
                return findRemovingIndex(x, (l + r) / 2 + 1, r); //right half recursion
            } else {
                return (l + r) / 2; //if compareTo gives 0, the 2 objects are the same
            }
        }
    }

    public boolean remove(Kid x) {
        if(empty()) {
            return false;
        } else {
            int index = findRemovingIndex(x, 0, length - 1);

            if(index != -1) {
                if(index == length - 1) {
                    list[index] = null;
                } else {
                    for(int i = index; i < length - 1; ++i) {
                        list[i] = list[i + 1];
                    }
                    list[length - 1] = null;
                }
                --length;
            }

            return true;
        }
    }
    //Utility--------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String str = "{";
        for(int i = 0; i < length && list[i] != null; ++i) {
            if(i > 0)
                str += ", ";

            str += "<" + list[i].toString() +">";
        }
        str += "}";

        return str;
    }
    //---------------------------------------------------------------------------------------------------------------------------
}

class ChildrenDemo {
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
        System.out.print("...press enter to continue...");
        t.nextLine();
    }

    public static void prova1() {
        Children c = new Children();

        try {
            c.add(new Kid("Pierino", "Rossi", 7));
            c.add(new Kid("Piero", "Angela", 4));

        } catch (Exception e) {System.out.println(e.getMessage());}
        System.out.println(c.toString());

        try {
            c.add(new Kid("Anna", "Gentile", 6));
            c.add(new Kid("Zorro", "Babbu", 5));
            c.add(new Kid("Zorra", "Babbu", 8));
            c.add(new Kid("Claudio", "Polli", 3));
            c.add(new Kid("Tony", "Stark", 47));
        } catch (Exception e) {System.out.println(e.getMessage());}
        System.out.println("\n\n");
        System.out.println(c.toString());
    }

    public static void prova2() {
        Children c = new Children();
        System.out.println(c.toString());
        pause();

        try {
            c.add(new Kid("Tony", "Stark", 46));
        } catch (Exception e) {System.out.println(ANSI_RED + "Error message: " + e.getMessage() + ANSI_RESET);}
        System.out.println(c.toString());
        pause();

        try {
            c.add(new Kid("Mario", "Rossi", 11));
            c.add(new Kid("Zeno", "Coscienzo", 30));
            c.add(new Kid("Centauri", "Alfa", 30));
            c.add(new Kid("Michele", "Monza", 20));
        } catch(Exception e) {System.out.println(ANSI_RED + "Error message: " + e.getMessage() + ANSI_RESET);}
        System.out.println(c.toString());
        pause();
    }

    public static void prova3() {
        Kid[] list = null;
        try {
            list = new Kid[] {
                        new Kid("Nome", "AA", 3),
                        new Kid("Nome", "B", 3),
                        new Kid("Nome", "C", 3),
                        new Kid("Nome", "D", 3),
                        new Kid("Nome", "E", 3),
                        new Kid("Nome", "F", 3),
                        new Kid("Nome", "G", 3),
                        new Kid("Nome", "H", 3),
                        new Kid("Nome", "I", 3),
                        new Kid("Nome", "J", 3)
                                   };
        } catch (Exception e) {System.out.println("Exception: " + e.getMessage());}
        Children c = new Children();
        c.setLength(10);
        c.setList(list);

        Scanner tastiera = new Scanner(System.in);
        String name, surname, age;
        int index;
        Kid k = null;

        for(int i = 0; i < 15; ++i) {
            System.out.println("Inserire dati bambino: ");

            name = tastiera.nextLine();
            surname = tastiera.nextLine();
            age = tastiera.nextLine();
            try {
                k = new Kid(name, surname, Integer.parseInt(age));
            } catch (Exception e) {System.out.println("Exception: " + e.getMessage());}
            index = c.findRemovingIndex(k, 0, c.getLength() - 1);
            System.out.println(ANSI_GREEN + c.toString() + ANSI_RESET);
            System.out.println(ANSI_BLUE + k.toString() + ", index: " + index + ANSI_RESET);
        }
    }

    public static void prova4() {
        Children elenco = new Children();
        String choice = "", name, surname, age;
        Scanner tast = new Scanner(System.in);

        while(!choice.equals("e")) {
            System.out.println(ANSI_BLUE + elenco.toString() + ANSI_RESET);
            System.out.println("Inserire dati animato:");
            System.out.print("Nome: ");
            name = tast.nextLine();
            System.out.print("Cognome: ");
            surname = tast.nextLine();
            System.out.print("Eta': ");
            age = tast.nextLine();
            System.out.print("\nadd per aggiungere, rem per rimuovere: ");
            choice = tast.nextLine();

            try {
                if(choice.equalsIgnoreCase("add")) {
                    elenco.add(new Kid(name, surname, Integer.parseInt(age)));
                } else if(choice.equalsIgnoreCase("rem")) {
                    elenco.remove(new Kid(name, surname, Integer.parseInt(age)));
                }
            } catch(Exception e) {System.out.println(ANSI_RED + "Exception: " + e.getMessage() + ANSI_RESET);}
        }
    }

    public static void main(String[] args) {
        //prova1();
        //prova2();
        //prova3();
        prova4();
    }
}

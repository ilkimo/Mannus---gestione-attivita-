import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.Serializable;
//import java.util.Scanner; //only used in test class KidDemo {...}

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Kid implements Serializable, Comparable<Kid> {
    private String name, surname;
    private int age;
    private String[] activities_submitted, permissions, allergy; //if ever used, implement check in method kid.equals(Kid other)

    public Kid(String name, String surname, int age) throws AgeException, NameException, SurnameException {
        if(age < 0)               {throw new AgeException("L'eta' dell'animato non puo' essere negativa");}
        if(name.length() == 0)    {throw new NameException("Errore, nome non inserito");}
        if(surname.length() == 0) {throw new SurnameException("Errore, cognome non inserito");}
        if(!validName(name))      {throw new NameException("Errore, il nome puo' contenere solo lettere e spazi \ne deve essere di lunghezza compresa fra 1 e 20");}
        if(!validName(surname))   {throw new SurnameException("Errore, il cognome puo' contenere solo lettere e spazi \ne deve essere di lunghezza compresa fra 1 e 20");}

        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Kid(String name, String surname) throws NameException, SurnameException {
        if(name.length() == 0)    {throw new NameException("Errore, nome non inserito");}
        if(surname.length() == 0) {throw new SurnameException("Errore, cognome non inserito");}
        if(!validName(name))      {throw new NameException("Errore, il nome puo' contenere solo lettere e spazi \ne deve essere di lunghezza compresa fra 1 e 20");}
        if(!validName(surname))   {throw new SurnameException("Errore, il cognome puo' contenere solo lettere e spazi \ne deve essere di lunghezza compresa fra 1 e 20");}

        this.name = name;
        this.surname = surname;
    }

    //Set() && Get() methods----------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String getName() {return name;}

    public String getSurname() {return surname;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}
    //other methods-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
     * Checks if the given String has length > 0 && length < 21 and contains only [a-zA-Z]+
     * <p>
     * The String must contain at least 1 non 'space' character
     * </p>
     */
     private static boolean validName(String str) {
         boolean res = true;

         if(str.length() > 0 && str.length() < 21) {
             Pattern p = Pattern.compile("[^a-zA-Z ]");
             Matcher m;

             m = p.matcher(str);
             res = !m.find();

             if(res) {
                 p = Pattern.compile("[a-zA-Z]");
                 m = p.matcher(str);
                 res = m.find();
             }
         } else {
             res = false;
         }

         return res;
     }
     //Utility-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     @Override
     public boolean equals(Object obj) {
         if(obj instanceof Kid) {

             return name.equalsIgnoreCase(((Kid)obj).getName()) && surname.equalsIgnoreCase(((Kid)obj).getSurname()) && (age == ((Kid)obj).getAge());
         } else {
             return false;
         }
     }

     @Override
     public String toString() {
         return surname + "-" + name + "-" + age;
     }

     @Override
     public int compareTo(Kid other) {
         if(surname.compareToIgnoreCase(other.getSurname()) != 0) {
             return surname.compareToIgnoreCase(other.getSurname());
         } else {
             if(name.compareTo(other.getName()) != 0) {
                 return name.compareToIgnoreCase(other.getName());
             } else {
                 if(age < other.getAge()) {
                     return -1;
                 } else {
                     if(age > other.getAge()) {
                         return 1;
                     } else {
                         return 0;
                     }
                 }
             }
         }
     }
     //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}









/*class KidDemo { //test class
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner tastiera = new Scanner(System.in);

    public static void main(String[] args) {
        String name = "", surname = "";
        Kid prova = null;
        int age;

        while(!name.equals("e")) {
            System.out.print("Insert name: ");
            name = tastiera.nextLine();
            System.out.print("Insert surname: ");
            surname = tastiera.nextLine();
            System.out.print("Insert age: ");
            age = Integer.parseInt(tastiera.nextLine());

            try {
                prova = new Kid(name, surname, age);
            } catch(Exception e) {System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);;}
        }
    }
}*/

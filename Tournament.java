import java.util.Scanner;
/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */
public abstract class Tournament {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    protected Children competitors;
    protected String[] matches;

    public abstract String[] getNextRound();
    public abstract void printTournament();

    public void orderByAge() {
        if(competitors != null)
            competitors.orderByAge();
    }

    public static Children makeCompetitorsList() {
        Children myCompetitors = new Children();
        Scanner t = new Scanner(System.in);
        String choice = "y", name, surname, age;

        while(choice.equalsIgnoreCase("y")) {
            System.out.print("Inserire nome giocatore: ");
            name = t.nextLine();
            System.out.print("Inserire cognome giocatore: ");
            surname = t.nextLine();
            System.out.print("Inserire eta' giocatore: ");
            age = t.nextLine();
            System.out.print(ANSI_BLUE + "Continuare? (inviare 'y' per si, altro per uscire)" + ANSI_RESET);
            choice = t.nextLine();
            try {
                myCompetitors.add(new Kid(name, surname, Integer.parseInt(age)));
            } catch(Exception e) {System.out.println("Eccezione: " + e.getMessage());}
        }

        return myCompetitors;
    }
}

class PiramidalTournament extends Tournament {
    public PiramidalTournament(Children competitors) {
        this.competitors = competitors;
        orderByAge();
        System.out.println(competitors.toString());
    }

    public String[] getNextRound() {
        return null; //cancel me
    }

    public void printTournament() {

    }
}

class TournamentDemo {
    public static void main(String[] args) {
        Tournament torneo = new PiramidalTournament(Tournament.makeCompetitorsList());
    }
}

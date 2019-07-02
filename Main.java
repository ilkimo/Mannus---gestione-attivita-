import javax.swing.JFrame;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Main {
    /**
     * Width of the Application's frame
     */
    public static final int WIDTH = 1500;
    /**
     * Height of the Application's frame
     */
    public static final int HEIGHT = 900;

    /**
     * Starts the application by opening it's frame
     */
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Mannus club - gestione centro estivo");
        mainFrame.setSize(WIDTH, HEIGHT);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setVisible(true);
    }
}

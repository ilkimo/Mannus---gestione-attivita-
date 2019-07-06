import javax.swing.JFrame;

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

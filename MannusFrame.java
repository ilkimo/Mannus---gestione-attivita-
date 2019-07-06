import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MannusFrame extends JFrame {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    //Constructors---------------------------------------------------------------------------------------------------------
    public MannusFrame() {
        super("Mannus club - gestione centro estivo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("prova"));
        MainWindow editor = new WindowIscritti(this, 25, 250, getGraphics());
        add(editor);
    }
    //---------------------------------------------------------------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println(getSize().getWidth() + ", " + getSize().getHeight());
    }
    //---------------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------------------------------
}

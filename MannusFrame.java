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
        MainWindow editor = new WindowIscritti(getGraphics()) {
            public int myGetWidth() {return (int)(getSize().getWidth() - (2d * (double)myGetX()));}

            public int myGetHeight() {return (int)(getSize().getHeight() - ((double)myGetY() + (double)myGetX()));}

            public int myGetX() {return (int)(getSize().getWidth() / 48d);}

            public int myGetY() {return (int)(getSize().getHeight() / 4d);}
        };
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

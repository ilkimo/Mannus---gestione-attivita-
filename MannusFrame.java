import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Component.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MannusFrame extends JFrame implements WindowListener {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    private MyEditor editor;
    //Constructors---------------------------------------------------------------------------------------------------------
    public MannusFrame(AppCore app) {
        super("Mannus club - gestione centro estivo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Desideri salvare i progressi?");
                switch(i) {
                    case 0: //YES
                        //save stuff DA FAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
                        System.exit(0);
                        break;
                    case 1: //NO
                        //exit without saving DA FAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
                        System.exit(0);
                        break;
                    case 2: //CANCEL
                        //keeps running
                        break;
                }
            }
        });

        add(new JLabel("prova")); //sta roba non si vede perche' c'e' l'altra finestra
        editor = new WindowIscritti(getGraphics(), app){
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

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Sono un figo della madonna");
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("trovato");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }
    //---------------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------------------------------
}

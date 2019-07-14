import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Component;
//Checkbox
//List
//PopupMenu
//

public abstract class MainWindow extends JComponent {
    private Children kids;
    private Graphics g;
    KidsGrid grid;

    public MainWindow(Graphics g) {
        kids = null;
        this.g = g;
        grid = new KidsGrid(this) {
            @Override
            public void paint(Graphics g) {
                g.drawRect(myGetX(), myGetY(), myGetWidth(), myGetHeight());
            }
        };
        add(grid);
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public abstract int myGetWidth();

    public abstract int myGetHeight();

    public abstract int myGetX();

    public abstract int myGetY();
    //---------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        Component[] components = getComponents();

        for(int i = 0; i < components.length; ++i) {
            components[i].paint(g);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}

abstract class WindowIscritti extends MainWindow {
    public WindowIscritti(Graphics g) {
        super(g);
    }
}

abstract class GestioneAttivita extends MainWindow {
    public GestioneAttivita(Graphics g) {
        super(g);
    }
}

abstract class CalendarioTurni extends MainWindow {
    public CalendarioTurni(Graphics g) {
        super(g);
    }
}

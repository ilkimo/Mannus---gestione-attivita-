import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Component;
//Checkbox
//List
//PopupMenu
//

public class MainWindow extends JComponent {
    private int upLeftCornerX, upLeftCornerY, width, height;
    private Children kids;
    private Graphics g;
    Kidsgrid grid;
    MannusFrame parent;

    public MainWindow(MannusFrame parent, int upLeftCornerX, int upLeftCornerY, Graphics g) {
        this.upLeftCornerX = upLeftCornerX;
        this.upLeftCornerY = upLeftCornerY;
        width = MannusFrame.WIDTH - (2 * upLeftCornerX);
        height = MannusFrame.HEIGHT - (upLeftCornerY + upLeftCornerX * 2);
        kids = null;
        this.g = g;
        this.parent = parent;
        grid = new KidsGrid(parent, upLeftCornerX, upLeftCornerY, width, height);
        add(grid);
    }
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

class WindowIscritti extends MainWindow {
    public WindowIscritti(MannusFrame parent, int upLeftCornerX, int upLeftCornerY, Graphics g) {
        super(parent, upLeftCornerX, upLeftCornerY, g);
    }
}

class GestioneAttivita extends MainWindow {
    public GestioneAttivita(MannusFrame parent, int upLeftCornerX, int upLeftCornerY, Graphics g) {
        super(parent, upLeftCornerX, upLeftCornerY, g);
    }
}

class CalendarioTurni extends MainWindow {
    public CalendarioTurni(MannusFrame parent, int upLeftCornerX, int upLeftCornerY, Graphics g) {
        super(parent, upLeftCornerX, upLeftCornerY, g);
    }
}

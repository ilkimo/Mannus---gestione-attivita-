import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Component;
//Checkbox
//List
//PopupMenu
//

public abstract class MyEditor extends JComponent {
    AppCore app;
    private Graphics g;
    KidsGrid borders;

    public MyEditor(Graphics g, AppCore app) {
        this.app = app;
        this.g = g;
        borders = new KidsGrid(this) {
            @Override
            public void paint(Graphics g) {
                g.drawRect(myGetX(), myGetY(), myGetWidth(), myGetHeight());
            }
        };
        add(borders);
        //cancel me
        add(new Component(){
                                @Override
                                public void paint(Graphics g) {
                                    g.drawRect(myGetX(), myGetY(), myGetWidth() / 2, myGetHeight() / 2);
                                }
                           });
        //cancel me
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

abstract class WindowIscritti extends MyEditor {
    public WindowIscritti(Graphics g, AppCore app) {
        super(g, app);
    }
}

abstract class GestioneAttivita extends MyEditor {
    public GestioneAttivita(Graphics g, AppCore app) {
        super(g, app);
    }
}

abstract class CalendarioTurni extends MyEditor {
    public CalendarioTurni(Graphics g, AppCore app) {
        super(g, app);
    }
}

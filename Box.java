import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class Box extends JComponent {
    private int x, y, width, height;
    MannusFrame parent;
    //---------------------------------------------------------------------------------------------------------------------------
    public Box(MannusFrame parent, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.parent = parent;
    }
    //---------------------------------------------------------------------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int)(x * parent.getSize().getWidth() / MannusFrame.WIDTH), (int)(y * parent.getSize().getHeight() / MannusFrame.HEIGHT), (int)(width * parent.getSize().getWidth() / MannusFrame.WIDTH), (int)(height * parent.getSize().getHeight() / MannusFrame.HEIGHT));
    }
    //---------------------------------------------------------------------------------------------------------------------------
}

class KidsGrid extends Box {
    public KidsGrid(MannusFrame parent, int x, int y, int width, int height) {
        super(parent, x, y, width, height);

        //ora devo aggiungere le varie righe in cui verrano poi inseriti i dati, meglio creare un array di celle di dimensione x
        //la posso maneggiare tranquillamente
    }
}

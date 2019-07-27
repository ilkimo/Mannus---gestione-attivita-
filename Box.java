import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class Box extends JComponent {
    MyEditor par;
    //---------------------------------------------------------------------------------------------------------------------------
    public Box(MyEditor par) {
        this.par = par;
    }
    //---------------------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------------------------------------
}

class KidsGrid extends Box {
    public KidsGrid(MyEditor par) {
        super(par);

        //ora devo aggiungere le varie righe in cui verrano poi inseriti i dati, meglio creare un array di celle di dimensione x
        //la posso maneggiare tranquillamente
    }
}

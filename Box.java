import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class Box extends JComponent {
    MainWindow par;
    //---------------------------------------------------------------------------------------------------------------------------
    public Box(MainWindow par) {
        this.par = par;
    }
    //---------------------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------------------------------------
}

class KidsGrid extends Box {
    public KidsGrid(MainWindow par) {
        super(par);

        //ora devo aggiungere le varie righe in cui verrano poi inseriti i dati, meglio creare un array di celle di dimensione x
        //la posso maneggiare tranquillamente
    }
}

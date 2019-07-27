import javax.swing.JFrame;
import java.io.File;

/**
 * @author Kim Viberti <vibertikim@yahoo.it>
 * @since 2019/07/27
 * Class invariants:
 *   1) nSeasons always reflects number of items in season_list[]
 */
public class AppCore {
    public String current_date; //format "yyyy/mm/dd": months indexed [1-12] (July is 7...)
    public String year, month, day; //month indexed [1-12] (like above)
    private String binary_path_name; //C:\Users\Kimjie\AppData\Roaming\Mannus Manager\bin
    private MannusSeason[] seasons_list;
    private int nSeasons;
    private JFrame mainFrame;
    //--------------------------------------------
    public AppCore(String date) throws Error {
        current_date = Main.get_actual_date();
        binary_path_name = DM.application_start();

        String[] date_fields = current_date.split("/");
        date_fields[0] = year;
        date_fields[1] = month;
        date_fields[2] = day;

        if(new File(binary_path_name + "S" + year).exists()) { //there is data stored in AppData/Raoming...
            //seasons_list
            System.out.println("DA FINIRE costruttore AppCore!");
        } else { //there is no stored data for the login season
            seasons_list = new MannusSeason[] {
                                                new MannusSeason(Integer.parseInt(year)),
                                                null
                                              };
            nSeasons = 1;
        }
        // Mostrare la finestra dell'applicazione
        mainFrame = new MannusFrame();
        mainFrame.paint(mainFrame.getGraphics());
        mainFrame.setVisible(true);
    }
    //Utility-------------------------------------
    public void add(MannusSeason s) {
        if(nSeasons >= seasons_list.length) {
            MannusSeason[] tmp = new MannusSeason[seasons_list.length * 2];

            for(int i = 0; i < nSeasons + 1; ++i) { //+1 to add s
                tmp[i] = seasons_list[i];
            }

            seasons_list = tmp;
        } else {
            seasons_list[nSeasons] = s;
        }
        ++nSeasons;
    }
    //--------------------------------------------
}

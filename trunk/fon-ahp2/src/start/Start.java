/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.ACStorage;
import exception.MarkNotInSatScaleException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alternative;
import model.Criteria;
import model.Goal;
import view.main.FrmMain;
import view.alternativesrating.PnlAlternativeMarks;

/**
 *
 * @author Ivan
 */
public class Start {

    public static void main(String args[]) {
        Goal g = new Goal("naci devojku", "treba naci najbolju devojku ");

        Alternative alternativa1 = new Alternative("marija", 1, "devojka1");
        Alternative alternativa2 = new Alternative("jovana", 2, "devojka2");
        Alternative alternativa3 = new Alternative("jelena", 3, "devojka3");

        Criteria kriterijum1 = new Criteria("visina", "visinaDevojke");
        Criteria kriterijum2 = new Criteria("lepota", "njena fizicka lepota");

        g.getListAlternative().add(alternativa3);
        g.getListAlternative().add(alternativa2);
        g.getListAlternative().add(alternativa1);
        g.getListCriteria().add(kriterijum2);
        g.getListCriteria().add(kriterijum1);

        ACStorage.getInstance().setGoal(g);
        ACStorage.getInstance().refreshData();

        FrmMain frmMain = new FrmMain();
        frmMain.setVisible(true);
    }
}

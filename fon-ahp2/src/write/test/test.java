/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package write.test;

import data.ACStorage;
import exception.MarkNotInSatScaleException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alternative;
import model.Criteria;
import model.Goal;
import write.CsvWriter;

/**
 *
 * @author Ivan
 */
public class test {

    public static void main(String args[]) throws IOException {
        try {
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

//            try {
//                g.addCriteriaWeight(kriterijum1, kriterijum2, 3);
//            } catch (MarkNotInSatScaleException ex) {
//                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//            }




//            ACStorage.getInstance().addAlternative(alternativa1);
//            ACStorage.getInstance().addAlternative(alternativa2);
//            ACStorage.getInstance().addAlternative(alternativa3);
//            ACStorage.getInstance().addCriteria(kriterijum1);
//            ACStorage.getInstance().addCriteria(kriterijum2);

//            alternativa1.insertMark(alternativa2, 0.4);
//            alternativa1.insertMark(alternativa3, 0.3);
//            alternativa2.insertMark(alternativa3, 0.8);



            CsvWriter.writeIntoCsv("C:\\Users\\Ivan\\Desktop\\test.csv");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
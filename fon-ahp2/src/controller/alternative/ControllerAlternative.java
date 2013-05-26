/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.alternative;

import data.ACStorage;
import javax.swing.JOptionPane;
import model.Alternative;
import view.alternative.FrmAddAlternative;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAlternative {
    //v2

    private FrmAddAlternative frmAlternative;

    private ControllerAlternative() {
    }

    public static ControllerAlternative getInstance() {
        return ControllerAlternativeHolder.INSTANCE;
    }

    private static class ControllerAlternativeHolder {

        private static final ControllerAlternative INSTANCE = new ControllerAlternative();
    }

    public void addAlternative(String alternativeName, String alternativeDescription) {
        if (alternativeName.equals("") || alternativeDescription.equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter Name and Description");
        } else {
            Alternative a = new Alternative(alternativeName, alternativeDescription);
            if (ACStorage.getInstance().getAlternatives().contains(a)) {
                JOptionPane.showMessageDialog(null, "The alternative already exists.");
            } else {
                ACStorage.getInstance().addAlternative(a);
                ACStorage.getInstance().refreshData();
                JOptionPane.showMessageDialog(null, "The alternative has been successfully added");
            }
        }
    }
}

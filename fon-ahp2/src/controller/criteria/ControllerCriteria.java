/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.criteria;

import data.ACStorage;
import javax.swing.JOptionPane;
import model.Criteria;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerCriteria {

    private ControllerCriteria() {
    }

    public static ControllerCriteria getInstance() {
        return ControllerCriteriaHolder.INSTANCE;
    }

    private static class ControllerCriteriaHolder {

        private static final ControllerCriteria INSTANCE = new ControllerCriteria();
    }

    public void addCriteria(String criteriaName, String criteriaDescription) {
        if (criteriaName.equalsIgnoreCase("") || criteriaDescription.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "You must enter Name and Description");
        } else {
            Criteria criteria = new Criteria(criteriaName, criteriaDescription);
            if (ACStorage.getInstance().getGoal().getListCriteria().contains(criteria)) {
                JOptionPane.showMessageDialog(null, "The criteria already exists");
            } else {
                ACStorage.getInstance().addCriteria(criteria);
                JOptionPane.showMessageDialog(null, "The criteria has been successfully added");
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.criteriarating;

import javax.swing.table.AbstractTableModel;
import model.CriteriaWeight;
import model.Goal;

/**
 *
 * @author Vlada
 */
public class TblModelNormalizedCriterias extends AbstractTableModel {

    Goal goal;

    public TblModelNormalizedCriterias() {
        goal = new Goal();
    }

    public TblModelNormalizedCriterias(Goal goal) {
        this.goal = goal;
    }

    @Override
    public int getRowCount() {
        return goal.getListCriteria().size();
    }

    @Override
    public int getColumnCount() {
        return goal.getListCriteria().size() + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return goal.getListCriteria().get(rowIndex);
        } else if (columnIndex == rowIndex + 1) {
            return 1;
        } else {
            CriteriaWeight cw = goal.getCriteriaWeightInList(
                    goal.getListCriteria().get(columnIndex - 1),
                    goal.getListCriteria().get(rowIndex));
            return cw.getNormalizedMark();
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return goal.getName();
        } else {
            return goal.getListCriteria().get(column - 1).getName();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.finalresults;

import javax.swing.table.AbstractTableModel;
import model.Goal;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TblModelFinalResults extends AbstractTableModel {

    Goal goal;

    public TblModelFinalResults(Goal goal) {
        this.goal = goal;
    }

    @Override
    public int getRowCount() {
        return goal.getListAlternative().size() + 1;
    }

    @Override
    public int getColumnCount() {
        return goal.getListCriteria().size() + 1;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return goal.getName();
        } else {
            return goal.getListCriteria().get(column - 1).getName();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (rowIndex == goal.getListAlternative().size()) {
                return "Criteria ponders";
            } else {
                return goal.getListAlternative().get(rowIndex);
            }
        } else {
            if (rowIndex == goal.getListAlternative().size()) {
                if (goal.getCriteriaPonders().size() > 0) {
                    return goal.getCriteriaPonders().get(columnIndex);
                } else {
                    return 0;
                }
            } else {
                if (goal.getListCriteria().get(columnIndex - 1).getAverageValue().size() > 0) {
                    return goal.getListCriteria().get(columnIndex - 1).getAverageValue().get(rowIndex);
                } else {
                    return 0;
                }
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

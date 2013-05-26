/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.criteriarating;

import data.ACStorage;
import javax.swing.table.AbstractTableModel;
import model.CriteriaWeight;
import model.Goal;

/**
 *
 * @author Ivan
 */
public class TblModelCriterias extends AbstractTableModel {
    //TODO sada ce sve ici iz Goal-a

    Goal goal;

    public TblModelCriterias() {
        goal = new Goal();
    }

    public TblModelCriterias(Goal goal) {
        this.goal = goal;
    }

    @Override
    public int getRowCount() {
        return goal.getListCriteria().size();
        //return ACStorage.getInstance().getCriterias().size(); 
    }

    @Override
    public int getColumnCount() {
        return goal.getListCriteria().size() + 1;
//      return ACStorage.getInstance().getGoal().getListCriteria().size() + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return goal.getListCriteria().get(rowIndex);
            //return ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex);
        } else if (columnIndex == rowIndex + 1) {
            return 1;
        } else {
//        if (columnIndex > rowIndex + 1) {
            CriteriaWeight cw = goal.getCriteriaWeightInList(
                    goal.getListCriteria().get(columnIndex - 1),
                    goal.getListCriteria().get(rowIndex));
            return cw.getMark();
//            return ACStorage.getInstance().getCriterias().get(rowIndex).getMark(ACStorage.getInstance().getCriterias().get(columnIndex - 1));
//        } else {
//            CriteriaWeight cw = goal.getCriteriaWeightInList(goal.getListCriteria().get(rowIndex), goal.getListCriteria().get(columnIndex - 1));
//            return cw.getMark();
//           return ACStorage.getInstance().getCriterias().get(rowIndex).getMark(ACStorage.getInstance().getCriterias().get(columnIndex - 1));
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return goal.getName();
        } else {
            return goal.getListCriteria().get(column - 1).getName();
//            return ACStorage.getInstance().getCriterias().get(column - 1).getName();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        if (columnIndex == rowIndex + 1) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        double value = Double.parseDouble(String.valueOf(aValue));

        if (columnIndex - 1 != rowIndex) {
            goal.getCriteriaWeightInList(goal.getListCriteria().get(rowIndex), goal.getListCriteria().get(columnIndex - 1)).setMark(value);
            goal.getCriteriaWeightInList(goal.getListCriteria().get(columnIndex - 1), goal.getListCriteria().get(rowIndex)).setMark(1.0 / value);

//            ACStorage.gw.setetInstance().getCriterias().get(rowIndex).getMarks().put(ACStorage.getInstance().getCriterias().get(columnIndex - 1), value);
//            ACStorage.getInstance().getCriterias().get(columnIndex - 1).getMarks().put(ACStorage.getInstance().getCriterias().get(rowIndex), 1 / value);
        }
    }
}

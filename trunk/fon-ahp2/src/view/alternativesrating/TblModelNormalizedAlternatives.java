/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.alternativesrating;

import data.ACStorage;
import javax.swing.table.AbstractTableModel;
import model.AlternativeRanks;
import model.Criteria;

/**
 *
 * @author student1
 */
public class TblModelNormalizedAlternatives extends AbstractTableModel {

    Criteria criteria;

    public TblModelNormalizedAlternatives() {
        criteria = new Criteria();
    }

    public TblModelNormalizedAlternatives(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int getRowCount() {
//        return ACStorage.getInstance().getAlternatives().size();
        return ACStorage.getInstance().getGoal().getListAlternative().size();
    }

    @Override
    public int getColumnCount() {
//        return  ACStorage.getInstance().getAlternatives().size() + 1;
        return ACStorage.getInstance().getGoal().getListAlternative().size() + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {

            return ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex);
        } else if (columnIndex == rowIndex + 1) {
            return 1;
        } else {

            AlternativeRanks ar = criteria.getAlternativeRankInList(
                    ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1),
                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex));
            return ar.getNormalizedMark();
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return criteria.getName();
        } else {
            return ACStorage.getInstance().getGoal().getListAlternative().get(column - 1).getName();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.alternativesrating;

import data.ACStorage;
import javax.swing.table.AbstractTableModel;
import model.Criteria;

/**
 *
 * @author Luke
 */
public class TblModelAverageValues extends AbstractTableModel {

    Criteria criteria;

    @Override
    public int getRowCount() {
        return ACStorage.getInstance().getGoal().getListAlternative().size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int br = 0;
        double s = 1;
        double prosek;
        for (int j = 0; j <= ACStorage.getInstance().getGoal().getListAlternative().size(); j++) {
            s += criteria.getAlternativeRankInList(
                    ACStorage.getInstance().getGoal().getListAlternative().get(j),
                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex)).getMark();
            br++;
        }
        prosek = s / br;
        criteria.getAverageValue().add(prosek);
        return prosek;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return "Srednje Vrednosti";
    }
}

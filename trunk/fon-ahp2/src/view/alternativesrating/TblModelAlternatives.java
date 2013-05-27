/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.alternativesrating;

import javax.swing.table.AbstractTableModel;
import data.ACStorage;
import exception.MarkNotInSatScaleException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlternativeRanks;
import model.Criteria;
import model.Goal;

/**
 * Klasa predstavlja model tabele.
 *
 * @author Marko Barackov
 */
public class TblModelAlternatives extends AbstractTableModel {
    //TODO odavde se radi sada sve, na kraju ce ici metoda sacuvaj kriterijum koja ce
    //sacuvati sve podatke

    Criteria criteria;

    public TblModelAlternatives(Criteria criteria) {
        this.criteria = criteria;
    }

    public TblModelAlternatives() {
        criteria = new Criteria();
    }

    /**
     * Ova metoda prebrojava koliko ima alternativa u listi alternativa i
     * postavlja taj broj za broj redova u tabeli.
     *
     * @return broj redova
     */
    @Override
    public int getRowCount() {
        return ACStorage.getInstance().getGoal().getListAlternative().size();
//        return criteria.getAllAlternativeRanks().size();
    }

    /**
     * Ova metoda prebrojava koliko ima alternativa u listi alternativa, sabira
     * taj broj sa 1 i postavlja ga kao broj kolona u tabeli. Sabira ga sa 1
     * zato sto je potrebna jedna vise kolona.
     *
     * @return broj kolona
     */
    @Override
    public int getColumnCount() {
//     return ACStorage.getInstance().getAlternatives().size() + 1;
        return ACStorage.getInstance().getGoal().getListAlternative().size() + 1;
    }

    /**
     * Ova metoda postavlja vrednost u tabeli, postavlja onu vrednost koja se
     * nalazi u mapi alternativa i u prvoj koloni postavlja imena alternativa.
     *
     * @param rowIndex indeks reda
     * @param columnIndex indeks kolone
     * @return vrednost u celiji
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
//            return ACStorage.getInstance().getAlternatives().get(rowIndex);
            return ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex);
        } else if (columnIndex == rowIndex + 1) {
            return 1;
        } else {
//        if (columnIndex > rowIndex) {
//            return ACStorage.getInstance().getAlternatives().get(rowIndex).getMark(ACStorage.getInstance().getAlternatives().get(columnIndex - 1));
            AlternativeRanks ar = criteria.getAlternativeRankInList(
                    ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1),
                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex));
            return ar.getMark();
        }
//        } else {
//            AlternativeRanks ar = criteria.getAlternativeRankInList(
//                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex),
//                    ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1));
//            return ar.getMark();
//        }
    }

    /**
     * Ova metoda postavlja da vrednosti u celiji tabele mogu da se menjaju.
     *
     * @param rowIndex indeks reda
     * @param columnIndex indeks kolone
     * @return da li je vrednost promenljiva
     */
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

    /**
     * Ova metoda postavlja imena kolona u tabeli.
     *
     * @param column indeks kolone
     * @return ime kolone
     */
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return criteria.getName();
        } else {
            return ACStorage.getInstance().getGoal().getListAlternative().get(column - 1).getName();
//            return ACStorage.getInstance().getAlternatives().get(column - 1).getName();
        }
    }

    /**
     * Ova metoda menja vrednosti u tabeli.
     *
     * @param aValue vrednost
     * @param rowIndex indeks reda Ova metoda menja vrednosti u tabeli.
     * @param columnIndex indeks kolone
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        double value = Double.parseDouble(String.valueOf(aValue));
        try {
//            if (columnIndex > rowIndex) {

            //            ACStorage.getInstance().getAlternatives().get(rowIndex).getMarks().put(ACStorage.getInstance().getAlternatives().get(columnIndex - 1), value);
            //            ACStorage.getInstance().getAlternatives().get(columnIndex - 1).getMarks().put(ACStorage.getInstance().getAlternatives().get(rowIndex), 1 / value);
            criteria.insertMark(
                    ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1),
                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex),
                    value);
            criteria.insertMark(
                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex),
                    ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1),
                    (1.0 / value));
//            } else if (columnIndex < rowIndex) {
//                criteria.insertMark(
//                        ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex),
//                        ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1), 
//                        value);
//                criteria.insertMark(ACStorage.getInstance().getGoal().getListAlternative().get(columnIndex - 1),
//                        ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex),(1.0/ value));
//            }
        } catch (MarkNotInSatScaleException ex) {
            Logger.getLogger(TblModelAlternatives.class.getName()).log(Level.SEVERE, null, ex);

        }
        fireTableDataChanged();

    }
}

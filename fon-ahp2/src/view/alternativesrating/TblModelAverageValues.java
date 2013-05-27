/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.alternativesrating;

import javax.swing.table.AbstractTableModel;
import model.Criteria;
import model.Goal;

/**
 *
 * @author Luke
 */
public class TblModelAverageValues extends AbstractTableModel {
    
    Criteria criteria;
    Goal goal;
    boolean izaberi;


    public TblModelAverageValues(Criteria criteria) {
        izaberi = true;
        this.criteria = criteria;
    }
    
    public TblModelAverageValues(){
        criteria = new Criteria();
    }
    
     public TblModelAverageValues(Goal goal) {
        izaberi = false;
        this.goal = goal;
    }
    
    
    
    
    

    @Override
    public int getRowCount() {
        if (izaberi)
            return goal.getListAlternative().size(); 
        else
            return goal.getListCriteria().size();
    }

    @Override
    public int getColumnCount() {
         if (izaberi)
            return goal.getListAlternative().size() + 2; 
        else
            return goal.getListCriteria().size() + 2;
      
//        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(izaberi){
            if (columnIndex == 0) {
             return goal.getListAlternative().get(rowIndex);
            } else if (columnIndex == rowIndex + 1) {
                return 1;
            } else if (columnIndex < rowIndex){
                return criteria.getAlternativeRankInList(
                        goal.getListAlternative().get(columnIndex - 1),
                        goal.getListAlternative().get(rowIndex)).getMark();
            }else {
                int br = 0;
                double s = 0;
                for (int i = 0; i <= goal.getListAlternative().size() ; i++) {
                    s = s + criteria.getAlternativeRankInList(
                        goal.getListAlternative().get(i),
                        goal.getListAlternative().get(rowIndex)).getMark();
                    br++;
                }
                criteria.getAverageValues()[rowIndex] = s/br;
                return s/br;
                }
            }
        else{
            if (columnIndex == 0) {
             return goal.getListCriteria().get(rowIndex);
            } else if (columnIndex == rowIndex + 1) {
                return 1;
            } else if (columnIndex < rowIndex){
                return goal.getCriteriaWeightInList(
                       goal.getListCriteria().get(columnIndex - 1),
                       goal.getListCriteria().get(rowIndex)).getMark();
            }else {
                int br = 0;
                double s = 0;
                for (int i = 0; i <= goal.getListCriteria().size() ; i++) {
                    s = s + goal.getCriteriaWeightInList(
                   goal.getListCriteria().get(i),
                   goal.getListCriteria().get(rowIndex)).getMark();
                    br++;
                }
                goal.getCriteriaPonders()[rowIndex] = s/br;
                return s/br;
                }
            
        
        }
        }
//            int br=0;
//            double s = 1;
//            double prosek;
//            for (int j = 0; j <= ACStorage.getInstance().getGoal().getListAlternative().size(); j++) {
//                s+=criteria.getAlternativeRankInList(
//                    ACStorage.getInstance().getGoal().getListAlternative().get(j),
//                    ACStorage.getInstance().getGoal().getListAlternative().get(rowIndex)).getMark();
//                br++;
//            }
//            prosek = s/br;
//            criteria.getAverageValue().add(prosek);
//        return prosek;
    

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
         if (columnIndex == 0 || columnIndex == rowIndex +1 || columnIndex == getColumnCount() - 1)
            return false;
        return true;
    }

    @Override
    public String getColumnName(int column) {
       if (izaberi){
           if (column == 0) {
            return criteria.getName();
        } else
           if (getColumnCount() - 1 != column ){
            return goal.getListAlternative().get(column - 1).getName();
           }
           else
               return "Average values";
       }else { 
           if (column == 0) {
            return goal.getName();
        } else{
            if (getColumnCount() - 1 != column ){
                return goal.getListCriteria().get(column - 1).getName();
            }
            else
               return "Ponderi"; 
       
           }
       }
    }


}

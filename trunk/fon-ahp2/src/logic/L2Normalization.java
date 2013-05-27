/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import exception.MarkNotNormalizedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Criteria;
import model.Goal;
/**
 *
 * @author mzdv
 */
public class L2Normalization {
    
    //TODO Local testing
    
//    private HashMap<String, Double> marks;
//    
//    public L2Normalization(HashMap marks) {
//        this.marks = marks;
//    }
    @Deprecated
    public static Map L2Normalize(HashMap<String, Double> marks) {

        HashMap<String, Double> marksOriginal = marks;
        
        //Bucket to hold the L2 norm
        Double bucket = new Double(0);
        
        for (Map.Entry<String, Double> mapExtraction : marksOriginal.entrySet()) {
            bucket = bucket + Math.pow(mapExtraction.getValue(),2);
        }
        
        bucket = Math.sqrt(bucket);
        
        //Normalization
        for (Map.Entry<String, Double> mapInsertion : marksOriginal.entrySet()) {
            Double normalizedValue = new Double(Math.pow(mapInsertion.getValue(),2) / bucket);
            marksOriginal.put(mapInsertion.getKey(), normalizedValue);          
        }
        
        return marksOriginal;
    }

    @Override
    public void normalize(Goal goal) {
        Double bucket = new Double(0);
        for(int i = 0; i < goal.getCriteriaWeights().size(); i++) {
            bucket = bucket + Math.pow(goal.getCriteriaWeights().get(i).getMark(),2);
        }
        for(int j = 0; j < goal.getCriteriaWeights().size(); j++) {
            Double normalizedMark = new Double(Math.pow(goal.getCriteriaWeights().get(j).getMark(),2) / bucket);
            try {
                goal.addNormalizedCriteriaWeight(goal.getCriteriaWeights().get(j).getFirstCriteria(), goal.getCriteriaWeights().get(j).getSecondCriteria(), normalizedMark);
            } catch (MarkNotNormalizedException ex) {
                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void normalize(Criteria criteria) {
        Double bucket = new Double(0);
        for(int i = 0; i < criteria.getAllAlternativeRanks().size(); i++) {
            bucket = bucket + Math.pow(criteria.getAllAlternativeRanks().get(i).getMark(),2);
        }
        for(int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
            Double normalizedMark = new Double(Math.pow(criteria.getAllAlternativeRanks().get(j).getMark(),2) / bucket);
            try {
                criteria.insertNormalizedMark(criteria.getAllAlternativeRanks().get(j).getFirstAlternative(), criteria.getAllAlternativeRanks().get(j).getSecondAlternative(), normalizedMark);
            } catch (MarkNotNormalizedException ex) {
                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

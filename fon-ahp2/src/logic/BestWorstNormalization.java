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
public class BestWorstNormalization {
    
//    private HashMap<String, Double> marks;
//    
//    public BestWorstNormalization(HashMap marks) {
//        this.marks = marks;
//    }
    @Deprecated
    public static Map BestWorstNormalization(HashMap<String, Double> marks) {
        
        HashMap<String, Double> marksOriginal = marks;
        
        //Bucket to hold the BestWorst norm
        Double bucket;
        
        Double best = new Double(0);    //needs a low enough value to determine the max
        Double worst = new Double(100); //if it is zero it will never get a min value
        
        //Determining max and min of a map
        for (Map.Entry<String, Double> mapExtraction : marksOriginal.entrySet()) {
            best = Math.max(best, Math.abs(mapExtraction.getValue()));
            worst = Math.min(worst,Math.abs(mapExtraction.getValue()));
        }
        
        bucket = best - worst;
        
        //Normalization
        for (Map.Entry<String, Double> mapInsertion : marksOriginal.entrySet()) {
            Double normalizedValue = new Double((best - mapInsertion.getValue()) / bucket);
            marksOriginal.put(mapInsertion.getKey(), normalizedValue);
        }
        
        return marksOriginal;
    }
    
    @Override
    public void normalize(Goal goal) {
        Double bucket;
        
        Double best = new Double(0);
        Double worst = new Double(100);
        
        for(int i = 0; i < goal.getCriteriaWeights().size(); i++) {
            best = Math.max(best, Math.abs(goal.getCriteriaWeights().get(i).getMark()));
            worst = Math.min(worst, Math.abs(goal.getCriteriaWeights().get(i).getMark()));
        }
        
        bucket = best - worst;
        
        for(int j = 0; j < goal.getCriteriaWeights().size(); j++) {
            Double normalizedMark = new Double((best - goal.getCriteriaWeights().get(j).getMark()) / bucket);
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
        Double bucket;
        
        Double best = new Double(0);
        Double worst = new Double(100);
        
        for(int i = 0; i < criteria.getAllAlternativeRanks().size(); i++) {
            best = Math.max(best, Math.abs(criteria.getAllAlternativeRanks().get(i).getMark()));
            worst = Math.min(worst, Math.abs(criteria.getAllAlternativeRanks().get(i).getMark()));
        }
        
        bucket = best - worst;
        
        for(int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
            Double normalizedMark = new Double((best - criteria.getAllAlternativeRanks().get(j).getMark()) / bucket);
            try {
                criteria.insertNormalizedMark(criteria.getAllAlternativeRanks().get(j).getFirstAlternative(), criteria.getAllAlternativeRanks().get(j).getSecondAlternative(), normalizedMark);
            } catch (MarkNotNormalizedException ex) {
                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

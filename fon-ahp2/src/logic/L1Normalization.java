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
 * @author Djordje Gligorijevic
 */
public class L1Normalization implements Normalizer{
    
    //TODO Local testing
    /*
     * Ulazni parametar ce biti objekat Criteria ili Goal, proci ce se kroz njegove
     * liste ocena i tezina (paziti kako i sta) i tu ce se puniti normalized vrednosti!
     * 
     * 
     */
    

    
//    public L1Normalization(HashMap marks) {
//        this.marks = marks;
//    }
    @Deprecated
    public static  Map L1Normalize(HashMap<String, Double> marks) {
        
        HashMap<String, Double> marksOriginal = marks;
        
        //Bucket to hold the L1 norm
        Double bucket = new Double(0);
        
        for (Map.Entry<String, Double> mapExtraction : marksOriginal.entrySet()) {
            bucket = bucket + Math.abs(mapExtraction.getValue());
        }
        
        //Normalization
        for (Map.Entry<String, Double> mapInsertion : marksOriginal.entrySet()) {
            Double normalizedValue = new Double(Math.abs(mapInsertion.getValue()) / bucket);
            marks.put(mapInsertion.getKey(), normalizedValue);          
        }
        
        return marksOriginal;
    } 

    @Override
    public void normalize(Goal goal) {
        Double bucket = new Double(0);
        for(int i = 0; i < goal.getCriteriaWeights().size(); i++) {
            bucket = bucket + Math.abs(goal.getCriteriaWeights().get(i).getMark());
        }
        for(int j = 0; j < goal.getCriteriaWeights().size(); j++) {
            Double normalizedMark = new Double(Math.abs(goal.getCriteriaWeights().get(j).getMark() / bucket));
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
            bucket = bucket + Math.abs(criteria.getAllAlternativeRanks().get(i).getMark());
        }
        for(int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
            Double normalizedMark = new Double(Math.abs(criteria.getAllAlternativeRanks().get(j).getMark() / bucket));
            try {
                criteria.insertNormalizedMark(criteria.getAllAlternativeRanks().get(j).getFirstAlternative(), criteria.getAllAlternativeRanks().get(j).getSecondAlternative(), normalizedMark);
            } catch (MarkNotNormalizedException ex) {
                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

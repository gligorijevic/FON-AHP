/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.ACStorage;
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
public class LInfinityNormalization implements Normalizer {

    //TODO Local testing
//    private HashMap<String, Double> marks;
//    
//    public LInfinityNormalization(HashMap marks) {
//        this.marks = marks;
//    }
    @Deprecated
    public static Map LInfinityNormalize(HashMap<String, Double> marks) {

        HashMap<String, Double> marksOriginal = marks;

        //Bucket to hold the LInfinity norm
        Double bucket = new Double(0);

        //Filling the bucket by determining the max of two numbers
        for (Map.Entry<String, Double> mapExtraction : marksOriginal.entrySet()) {
            bucket = Math.max(bucket, Math.abs(mapExtraction.getValue()));
        }

        //Normalization
        for (Map.Entry<String, Double> mapInsertion : marksOriginal.entrySet()) {
            Double normalizedValue = new Double(mapInsertion.getValue() / bucket);
            marksOriginal.put(mapInsertion.getKey(), normalizedValue);
        }

        return marksOriginal;
    }

    @Override
    public void normalize(Goal goal) {
//        Double bucket = new Double(0);
//        for(int i = 0; i < goal.getCriteriaWeights().size(); i++) {
//            bucket = Math.max(bucket, goal.getCriteriaWeights().get(i).getMark());
//        }
//        for(int j = 0; j < goal.getCriteriaWeights().size(); j++) {
//            Double normalizedMark = new Double(goal.getCriteriaWeights().get(j).getMark() / bucket);
//            try {
//                goal.addNormalizedCriteriaWeight(goal.getCriteriaWeights().get(j).getFirstCriteria(), goal.getCriteriaWeights().get(j).getSecondCriteria(), normalizedMark);
//            } catch (MarkNotNormalizedException ex) {
//                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        for (int i = 0; i < goal.getListCriteria().size(); i++) {
            double bucket = 0.0;
            for (int j = 0; j < goal.getCriteriaWeights().size(); j++) {
                if (goal.getListCriteria().get(i).equals(goal.getCriteriaWeights().get(j).getFirstCriteria())) {
                    bucket = Math.max(bucket, goal.getCriteriaWeights().get(j).getMark());
                }
            }
            for (int j = 0; j < goal.getCriteriaWeights().size(); j++) {
                if (goal.getListCriteria().get(i).equals(goal.getCriteriaWeights().get(j).getFirstCriteria())) {
                    goal.getCriteriaWeights().get(j).setNormalizedMark(goal.getCriteriaWeights().get(j).getMark() / bucket);
                }
            }
        }

    }

    @Override
    public void normalize(Criteria criteria) {
//        Double bucket = new Double(0);
//        for (int i = 0; i < criteria.getAllAlternativeRanks().size(); i++) {
//            bucket = Math.max(bucket, criteria.getAllAlternativeRanks().get(i).getMark());
//        }
//        for (int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
//            Double normalizedMark = new Double(criteria.getAllAlternativeRanks().get(j).getMark() / bucket);
//            try {
//                criteria.insertNormalizedMark(criteria.getAllAlternativeRanks().get(j).getFirstAlternative(), criteria.getAllAlternativeRanks().get(j).getSecondAlternative(), normalizedMark);
//            } catch (MarkNotNormalizedException ex) {
//                Logger.getLogger(L1Normalization.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        for (int i = 0; i < ACStorage.getInstance().getGoal().getListAlternative().size(); i++) {
            double bucket = 0.0;
            for (int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
                if (ACStorage.getInstance().getGoal().getListAlternative().get(i).equals(
                        criteria.getAllAlternativeRanks().get(j).getFirstAlternative())) {
                    bucket = Math.max(bucket, criteria.getAllAlternativeRanks().get(j).getMark());
                }
            }
            for (int j = 0; j < criteria.getAllAlternativeRanks().size(); j++) {
                if (ACStorage.getInstance().getGoal().getListAlternative().get(i).equals(
                        criteria.getAllAlternativeRanks().get(j).getFirstAlternative())) {
                    criteria.getAllAlternativeRanks().get(j).setNormalizedMark(
                            criteria.getAllAlternativeRanks().get(j).getMark() / bucket);
                }
            }
        }

    }
}

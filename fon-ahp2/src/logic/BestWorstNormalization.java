/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import java.util.Map;

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
}

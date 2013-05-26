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
public class LInfinityNormalization {
     
    //TODO Local testing
    
//    private HashMap<String, Double> marks;
//    
//    public LInfinityNormalization(HashMap marks) {
//        this.marks = marks;
//    }

    public  static Map LInfinityNormalize(HashMap<String, Double> marks) {

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
}

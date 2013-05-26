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
public class L2Normalization {
    
    //TODO Local testing
    
//    private HashMap<String, Double> marks;
//    
//    public L2Normalization(HashMap marks) {
//        this.marks = marks;
//    }

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
}

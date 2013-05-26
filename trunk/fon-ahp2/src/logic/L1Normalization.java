/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import java.util.Map;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void normalize(Criteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.ACStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.Alternative;

/**
 *
 * @author student1
 */
public class AverageAlternatives {

    public double average() {
        int mapSize;
        HashMap<Alternative, Double> weights = new HashMap<>();
        


        for (int i = 0; i < ACStorage.getInstance().getAlternatives().size(); i++) {
            if (weights.isEmpty()) {
                mapSize = ACStorage.getInstance().getAlternatives().get(0).getNormalizedMarks().size();
                weights = new HashMap();
                for (Iterator it = ACStorage.getInstance().getAlternatives().get(0).getNormalizedMarks().keySet().iterator(); it.hasNext();) {
                    Alternative key = (Alternative) it.next();
                    Double value = (Double) ACStorage.getInstance().getAlternatives().get(0).getNormalizedMarks().get(key);
                    weights.put(key, value);
                     
                }
            }else{
                
            }

//            if(ACStorage.getInstance().getAlternatives().get(i);
        }
        
        return 1; /// TO DO OVO OBRISI OBAVEZNO !!!!
    }
}

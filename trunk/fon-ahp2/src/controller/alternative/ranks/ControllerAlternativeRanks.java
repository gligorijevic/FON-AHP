        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.alternative.ranks;

import logic.Normalizer;
import model.Criteria;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAlternativeRanks {

    private ControllerAlternativeRanks() {
    }

    public static ControllerAlternativeRanks getInstance() {
        return ControllerAlternativeRanksHolder.INSTANCE;
    }

    private static class ControllerAlternativeRanksHolder {

        private static final ControllerAlternativeRanks INSTANCE = new ControllerAlternativeRanks();
    }

    public void next() {
    }

    public void previous() {
    }

    public void normalize(String normalizer, Criteria criteria) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ((Normalizer) Class.forName("logic." + normalizer).newInstance()).normalize(criteria);
    }
}

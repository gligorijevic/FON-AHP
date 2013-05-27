/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.criteria.weights;

import logic.Normalizer;
import model.Goal;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerCriteriaWeights {

    private ControllerCriteriaWeights() {
    }

    public static ControllerCriteriaWeights getInstance() {
        return ControllerCriteriaWeightsHolder.INSTANCE;
    }

    private static class ControllerCriteriaWeightsHolder {

        private static final ControllerCriteriaWeights INSTANCE = new ControllerCriteriaWeights();
    }

    public void normalize(String normalizer, Goal goal) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ((Normalizer) Class.forName("logic." + normalizer).newInstance()).normalize(goal);
    }
}

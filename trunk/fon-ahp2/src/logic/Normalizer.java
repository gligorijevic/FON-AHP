/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import model.Criteria;
import model.Goal;

/**
 *
 * @author Djordje Gligorijevic
 */
public interface Normalizer {

    public void normalize(Goal goal);

    public void normalize(Criteria criteria);
}

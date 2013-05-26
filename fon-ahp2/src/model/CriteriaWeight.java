/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CriteriaWeight {

    private Goal goal;
    private Criteria firstCriteria;
    private Criteria secondCriteria;
    private double mark;
    private double normalizedMark;

    public CriteriaWeight() {
    }

    public CriteriaWeight(Goal goal, Criteria firstCriteria, Criteria secondCriteria, double mark, double normalizedMark) {
        this.goal = goal;
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
        this.mark = mark;
        this.normalizedMark = normalizedMark;
    }

    /**
     * @return the goal
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    /**
     * @return the firstCriteria
     */
    public Criteria getFirstCriteria() {
        return firstCriteria;
    }

    /**
     * @param firstCriteria the firstCriteria to set
     */
    public void setFirstCriteria(Criteria firstCriteria) {
        this.firstCriteria = firstCriteria;
    }

    /**
     * @return the secondCriteria
     */
    public Criteria getSecondCriteria() {
        return secondCriteria;
    }

    /**
     * @param secondCriteria the secondCriteria to set
     */
    public void setSecondCriteria(Criteria secondCriteria) {
        this.secondCriteria = secondCriteria;
    }

    /**
     * @return the mark
     */
    public double getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(double mark) {
        this.mark = mark;
    }

    /**
     * @return the normalizedMark
     */
    public double getNormalizedMark() {
        return normalizedMark;
    }

    /**
     * @param normalizedMark the normalizedMark to set
     */
    public void setNormalizedMark(double normalizedMark) {
        this.normalizedMark = normalizedMark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CriteriaWeight) {
            if (this.firstCriteria.equals(((CriteriaWeight) obj).getFirstCriteria())
                    && this.secondCriteria.equals(((CriteriaWeight) obj).getSecondCriteria())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Djordje Gligorijevic
 */
public class AlternativeRanks {

    private Criteria criteria;
    private Alternative firstAlternative;
    private Alternative secondAlternative;
    private double mark;
    private double normalizedMark;

    public AlternativeRanks() {
    }

    public AlternativeRanks(Criteria criteria, Alternative firstAlternative, Alternative secondAlternative, double mark, double normalizedMark) {
        this.criteria = criteria;
        this.firstAlternative = firstAlternative;
        this.secondAlternative = secondAlternative;
        this.mark = mark;
        this.normalizedMark = normalizedMark;
    }

    /**
     * @return the criteria
     */
    public Criteria getCriteria() {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    /**
     * @return the firstAlternative
     */
    public Alternative getFirstAlternative() {
        return firstAlternative;
    }

    /**
     * @param firstAlternative the firstAlternative to set
     */
    public void setFirstAlternative(Alternative firstAlternative) {
        this.firstAlternative = firstAlternative;
    }

    /**
     * @return the secondAlternative
     */
    public Alternative getSecondAlternative() {
        return secondAlternative;
    }

    /**
     * @param secondAlternative the secondAlternative to set
     */
    public void setSecondAlternative(Alternative secondAlternative) {
        this.secondAlternative = secondAlternative;
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
        if (obj instanceof AlternativeRanks) {
            if (this.criteria.equals(((AlternativeRanks) obj).getCriteria())
                    && this.firstAlternative.equals(((AlternativeRanks) obj).getFirstAlternative())
                    && this.secondAlternative.equals(((AlternativeRanks) obj).getSecondAlternative())) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}

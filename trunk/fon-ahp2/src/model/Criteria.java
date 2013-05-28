/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.ACStorage;
import exception.MarkNotInSatScaleException;
import exception.MarkNotNormalizedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Criteria {

    private String name;
    private String description;
    private List<AlternativeRanks> allAlternativeRanks;
    
    @Deprecated
    private Map marks;
    @Deprecated
    private Map normalizedMarks;
    @Deprecated
    private Map altermativeGrades;
   
    private double[] averageValues;

    public Criteria() {
        marks = new HashMap();
        normalizedMarks = new HashMap();
        altermativeGrades = new HashMap();
        allAlternativeRanks = new ArrayList<>();
    }

    public Criteria(String name, String description) {
        this.name = name;
        this.description = description;
        averageValues = new double [ACStorage.getInstance().getGoal().getListAlternative().size()];

        marks = new HashMap();
        normalizedMarks = new HashMap();
        altermativeGrades = new HashMap();
        
        allAlternativeRanks = new ArrayList<>();
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Deprecated
    public Map getMarks() {
        return marks;
    }

    @Deprecated
    public void setMarks(Map marks) {
        this.marks = marks;
    }

    @Deprecated
    public double getMark(Criteria criteria) {
        return (double) marks.get(criteria);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Criteria)) {
            return false;
        }
        Criteria cr = (Criteria) obj;
        if (name.equals(cr.getName()) && description.equals(cr.getDescription())) {
            return true;
        } else {
            return false;
        }
    }

    @Deprecated
    public Map getNormalizedMarks() {
        return normalizedMarks;
    }

    @Deprecated
    private void setNormalizedMarks(Map normalizedMarks) {
        this.normalizedMarks = normalizedMarks;
    }

    public AlternativeRanks getAlternativeRankInList(Alternative firstAlternative, Alternative secondAlternative) {
        for (AlternativeRanks alternativeRanks : allAlternativeRanks) {
            if (alternativeRanks.getFirstAlternative().equals(firstAlternative) && alternativeRanks.getSecondAlternative().equals(secondAlternative)) {
                return alternativeRanks;
            }
        }
        return null;
    }

    public void insertMark(Alternative firstAlternative, Alternative secondAlternative, double mark) throws MarkNotInSatScaleException {
        AlternativeRanks ranks = getAlternativeRankInList(firstAlternative, secondAlternative);
        if (mark > 1) {
            if (mark > 0 && mark < 10) {
                if (ranks == null) {
                    AlternativeRanks newAlternativeRanks = new AlternativeRanks(this, firstAlternative, secondAlternative, mark, -1.0);
                    allAlternativeRanks.add(newAlternativeRanks);
                } else {
                    for (AlternativeRanks alternativeRanks : allAlternativeRanks) {
                        if (alternativeRanks.getFirstAlternative().equals(firstAlternative) && alternativeRanks.getSecondAlternative().equals(secondAlternative)) {
                            alternativeRanks.setMark(mark);
                        }
                    }
                }
//                ACStorage.getInstance().refreshData();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        } else {
            if ((1 / mark) > 0 && (1 / mark) < 10) {
                if (ranks == null) {
                    AlternativeRanks newAlternativeRanks = new AlternativeRanks(this, firstAlternative, secondAlternative, mark, -1.0);
                    allAlternativeRanks.add(newAlternativeRanks);
                } else {
                    for (AlternativeRanks alternativeRanks : allAlternativeRanks) {
                        if (alternativeRanks.getFirstAlternative().equals(firstAlternative) && alternativeRanks.getSecondAlternative().equals(secondAlternative)) {
                            alternativeRanks.setMark(mark);
                        }
                    }
                }
//                ACStorage.getInstance().refreshData();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        }
    }

    public void insertNormalizedMark(Alternative firstAlternative, Alternative secondAlternative, double normalizedMark) throws MarkNotNormalizedException {
        AlternativeRanks ranks = getAlternativeRankInList(firstAlternative, secondAlternative);
        if (normalizedMark < 1) {
            if (ranks == null) {
                AlternativeRanks newAlternativeRanks = new AlternativeRanks(this, firstAlternative, secondAlternative, -1.0, normalizedMark);
                allAlternativeRanks.add(newAlternativeRanks);
            } else {
                for (AlternativeRanks alternativeRanks : allAlternativeRanks) {
                    if (alternativeRanks.getFirstAlternative().equals(firstAlternative) && alternativeRanks.getSecondAlternative().equals(secondAlternative)) {
                        alternativeRanks.setNormalizedMark(normalizedMark);
                    }
                }
            }
            ACStorage.getInstance().refreshMapsAlternative();
        } else {
            throw new MarkNotNormalizedException("Mark is not normalized!");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public List<AlternativeRanks> getAllAlternativeRanks() {
        return allAlternativeRanks;
    }

    public void setAllAlternativeRanks(List<AlternativeRanks> allAlternativeRanks) {
        this.allAlternativeRanks = allAlternativeRanks;
    }

    /**
     * @return the criteriaPonders
     */
    public double[] getAverageValues() {
        return averageValues;
    }

    /**
     * @param criteriaPonders the criteriaPonders to set
     */
    public void setAverageValues(double[] averageValues) {
        this.averageValues = averageValues;
    }
}

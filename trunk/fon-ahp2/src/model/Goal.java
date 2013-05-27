/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.ACStorage;
import exception.MarkNotInSatScaleException;
import exception.MarkNotNormalizedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Goal {

    int id;
    String name;
    String description;
    @Deprecated
    private Map weigths;
    private List<Criteria> listCriteria;
    private List<Alternative> listAlternative;
    private List<CriteriaWeight> criteriaWeights;
    
    private double[] criteriaPonders;

    public Goal() {
        listCriteria = new ArrayList<>();
        listAlternative = new ArrayList<>();
        criteriaWeights = new ArrayList<>();
//        criteriaPonders = new double[ACStorage.getInstance().getGoal().getListAlternative().size()];
    }

    public Goal(String name, String description) {
        this.name = name;
        this.description = description;
        listCriteria = new ArrayList<>();
        listAlternative = new ArrayList<>();
        criteriaWeights = new ArrayList<>();
//        criteriaPonders = new double[ACStorage.getInstance().getGoal().getListAlternative().size()];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goal{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof Goal)) {
            return false;
        }
        Goal g = (Goal) o;

        if (name.equals(g.getName()) && description.equals(g.getDescription())) {
            return true;
        }
        return false;
    }

    /**
     * @return the weigths
     */
    @Deprecated
    public Map getWeigths() {
        return weigths;
    }

    /**
     * @param weigths the weigths to set
     */
    @Deprecated
    public void setWeigths(Map weigths) {
        this.weigths = weigths;
    }

    /**
     * @return the listAlternative
     */
    public List<Alternative> getListAlternative() {
        return listAlternative;
    }

    /**
     * @param listAlternative the listAlternative to set
     */
    public void setListAlternative(List<Alternative> listAlternative) {
        this.listAlternative = listAlternative;
    }

    /**
     * @return the listCriteria
     */
    public List<Criteria> getListCriteria() {
        return listCriteria;
    }

    /**
     * @param listCriteria the listCriteria to set
     */
    public void setListCriteria(List<Criteria> listCriteria) {
        this.listCriteria = listCriteria;
    }

    public CriteriaWeight getCriteriaWeightInList(Criteria firstCriteria, Criteria secondCriteria) {
        for (CriteriaWeight criteriaWeight : getCriteriaWeights()) {
            if (criteriaWeight.getFirstCriteria().equals(firstCriteria) && criteriaWeight.getSecondCriteria().equals(secondCriteria)) {
                return criteriaWeight;
            }
        }
        return null;
    }

    public void addCriteriaWeight(Criteria firstCriteria, Criteria secondCriteria, double weight) throws MarkNotInSatScaleException {
        CriteriaWeight criteriaWeightFromList = getCriteriaWeightInList(firstCriteria, secondCriteria);
        if (weight > 1) {
            if (weight > 0 && weight < 10) {
                if (criteriaWeightFromList == null) {
                    CriteriaWeight newCriteriaWeight = new CriteriaWeight(this, firstCriteria, secondCriteria, weight, -1.0);
                    getCriteriaWeights().add(newCriteriaWeight);
                } else {
                    for (int i = 0; i < getCriteriaWeights().size(); i++) {
                        if (getCriteriaWeights().get(i).getFirstCriteria().equals(firstCriteria)
                                && getCriteriaWeights().get(i).getSecondCriteria().equals(secondCriteria)) {
                            getCriteriaWeights().get(i).setMark(weight);
                        }
                    }
//                    for (CriteriaWeight criteriaWeight : getCriteriaWeights()) {
//                        if (criteriaWeight.getFirstCriteria().equals(firstCriteria) && criteriaWeight.getSecondCriteria().equals(secondCriteria)) {
//                            criteriaWeight.setMark(weight);
//                        }
//                    }
                }
//                ACStorage.getInstance().refreshMapsAlternative();
                ACStorage.getInstance().refreshData();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        } else {
            if ((1 / weight) > 0 && (1 / weight) < 10) {
                if (criteriaWeightFromList == null) {
                    CriteriaWeight newCriteriaWeight = new CriteriaWeight(this, firstCriteria, secondCriteria, weight, -1.0);
                    getCriteriaWeights().add(newCriteriaWeight);
                } else {
                    for (int i = 0; i < getCriteriaWeights().size(); i++) {
                        if (getCriteriaWeights().get(i).getFirstCriteria().equals(firstCriteria)
                                && getCriteriaWeights().get(i).getSecondCriteria().equals(secondCriteria)) {
                            getCriteriaWeights().get(i).setMark(weight);
                        }
                    }
//                    for (CriteriaWeight criteriaWeight : getCriteriaWeights()) {
//                        if (criteriaWeight.getFirstCriteria().equals(firstCriteria) && criteriaWeight.getSecondCriteria().equals(secondCriteria)) {
//                            criteriaWeight.setMark(weight);
//                        }
//                    }
                }
//                ACStorage.getInstance().refreshMapsAlternative();
                ACStorage.getInstance().refreshData();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        }
    }

    public void addNormalizedCriteriaWeight(Criteria firstCriteria, Criteria secondCriteria, double normalizedWeight) throws MarkNotNormalizedException {
        CriteriaWeight criteriaWeightFromList = getCriteriaWeightInList(firstCriteria, secondCriteria);
        if (normalizedWeight < 1) {
            if (criteriaWeightFromList == null) {
                CriteriaWeight newCriteriaWeight = new CriteriaWeight(this, firstCriteria, secondCriteria, -1.0, normalizedWeight);
                getCriteriaWeights().add(newCriteriaWeight);
            } else {
                for (CriteriaWeight criteriaWeight : getCriteriaWeights()) {
                    if (criteriaWeight.getFirstCriteria().equals(firstCriteria) && criteriaWeight.getSecondCriteria().equals(secondCriteria)) {
                        criteriaWeight.setNormalizedMark(normalizedWeight);
                    }
                }
            }
//            ACStorage.getInstance().refreshMapsAlternative();
            ACStorage.getInstance().refreshData();
        } else {
            throw new MarkNotNormalizedException("Mark is not normalized!");
        }

    }

    /**
     * @return the criteriaWeights
     */
    public List<CriteriaWeight> getCriteriaWeights() {
        return criteriaWeights;
    }

    /**
     * @param criteriaWeights the criteriaWeights to set
     */
    public void setCriteriaWeights(List<CriteriaWeight> criteriaWeights) {
        this.criteriaWeights = criteriaWeights;
    }

        /**
     * @return the criteriaPonders
     */
    public double[] getCriteriaPonders() {
        return criteriaPonders;
    }

    /**
     * @param criteriaPonders the criteriaPonders to set
     */
    public void setCriteriaPonders(double[] criteriaPonders) {
        this.criteriaPonders = criteriaPonders;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.ACStorage;
import exception.MarkNotInSatScaleException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Alternative {

    private String name;
    private int id;
    private String description;
    @Deprecated
    private Map marks;
    @Deprecated
    private Map normalizedMarks;
    @Deprecated
    private HashMap<Alternative, HashMap<String, Double>> allAlternativeGrades = new HashMap<>();

    public Alternative() {
        marks = new HashMap();
        normalizedMarks = new HashMap();

    }

    public Alternative(String name, int id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
        marks = new HashMap();
        normalizedMarks = new HashMap();

    }

    public Alternative(String name, String description) {
        this.name = name;
        this.description = description;
        marks = new HashMap();
    }

    /**
     * @return the name
     *
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description of alternative to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alternative)) {
            return false;
        } else {
            Alternative a = (Alternative) o;
            if (name.equals(a.getName()) && description.equals(a.getDescription())) {
                return true;
            } else {
                return false;
            }
        }
//        Alternative al = (Alternative) o;
//        if (name.equals(al.getName())
//                && id == al.getId()
//                && description.equals(al.getDescription())) {
//            return true;
//        } else {
//            return false;
//        }

    }

    /**
     * @return the marks
     */
    @Deprecated
    public Map getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    @Deprecated
    public void setMarks(Map marks) {
        this.marks = marks;
    }

    public void insertMark(Alternative alternative, double mark) throws MarkNotInSatScaleException {
        if (mark > 1) {
            if (mark > 0 && mark < 10) {
                marks.put(alternative, mark);
                ACStorage.getInstance().refreshMapsAlternative();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        } else {
            if ((1 / mark) > 0 && (1 / mark) < 10) {
                marks.put(alternative, mark);
                ACStorage.getInstance().refreshMapsAlternative();
            } else {
                throw new MarkNotInSatScaleException("Mark is not in Sati's scale!");
            }
        }
    }

    @Deprecated
    public double getMark(Alternative alternative) {
        return (double) marks.get(alternative);
    }

    /**
     * @return the normalizedMarks
     */
    @Deprecated
    public Map getNormalizedMarks() {
        return normalizedMarks;
    }

    /**
     * @param normalizedMarks the normalizedMarks to set
     */
    @Deprecated
    public void setNormalizedMarks(Map normalizedMarks) {
        this.normalizedMarks = normalizedMarks;
    }

    public void addAlternativesToMap(Alternative alternativeKey) {
        HashMap<String, Double> alternativeMap = new HashMap<>();
        allAlternativeGrades.put(alternativeKey, alternativeMap);
    }

    public Map getAlternativesFromMap(Alternative alternativeKey) {
        return allAlternativeGrades.get(alternativeKey);
    }

    public void setAlternativesToMap(Criteria criteria, Map marks) { //(Criteria criteria, Map marks) {
        //      Set<Alternative> keySet;
        //     keySet = maps.keySet();
        //     Criteria K;

        for (int i = 0; i < allAlternativeGrades.size(); i++) {
            HashMap<String, Double> temp = new HashMap<>();
            for (int j = 0; j < allAlternativeGrades.size(); j++) {
                temp.put(ACStorage.getInstance().getAlternatives().get(j).name,
                        ACStorage.getInstance().getAlternatives().get(i).getMark(ACStorage.getInstance().getAlternatives().get(j)));
            }
            allAlternativeGrades.put(ACStorage.getInstance().getAlternatives().get(i), temp);
        }





        //      for(int i = 0; i < keySet.size(); i++) {
        //         if(key.eq)
        //if(keySet.contains()) dodacemo kasnije, treba da se uporedjuje 0,0
        //iz getValueAt sa keySet i potom da se mapa prosledi u mapu koja odgovoara kljucu iz KeySet
    }
}

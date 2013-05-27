 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.Alternative;
import model.AlternativeRanks;
import model.Criteria;
import model.CriteriaWeight;
import model.Goal;
import view.main.FrmMain;

/**
 *
 * @author Vlada
 */
public class ACStorage {

    private FrmMain glavnaForma;
    private static ACStorage instance;
    private Goal goal;
    @Deprecated
    private List<Alternative> alternatives;
    @Deprecated
    private List<Criteria> criterias;
    @Deprecated
    private List<List<Double>> criteriaMatrix = new ArrayList<>();
    DefaultMutableTreeNode project;

    private ACStorage() {
        alternatives = new ArrayList<>();
        criterias = new ArrayList<>();
    }

    public static synchronized ACStorage getInstance() {
        if (instance == null) {
            instance = new ACStorage();
        }
        return instance;
    }

    public void addCriteria(Criteria criteria) {
        if (criteria != null) {
            goal.getListCriteria().add(criteria);
        }
//        refreshMapsCriteria();
        refreshData();
        refreshProjectPreview();
    }

    public void addAlternative(Alternative alternative) {
        if (alternative != null) {
            goal.getListAlternative().add(alternative);
        }
//        refreshMapsAlternative();
        refreshData();
        refreshProjectPreview();
    }

    public void removeAlternative(Alternative a) {
        if (goal.getListAlternative().contains(a)) {
            goal.getListAlternative().remove(a);
        }
    }

    /**
     * @return the alternatives
     */
    @Deprecated
    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    /**
     * @param alternatives the alternatives to set
     */
    @Deprecated
    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    /**
     * @return the criterias
     */
    @Deprecated
    public List<Criteria> getCriterias() {
        return criterias;
    }

    /**
     * @param criterias the criterias to set
     */
    @Deprecated
    public void setCriterias(List<Criteria> criterias) {
        this.criterias = criterias;
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

    public void removeCriteria(Criteria criteria) {
        goal.getListCriteria().remove(criteria);
//        criterias.remove(criteria);
    }

    //TODO omoguci dodavanje alternative i kriterijuma liste
    //omoguci vracanje alternative i kr. po unetom indexu i po unetoj alternativi ili kr.
//    public void foreach() {
//        for (Alternative alternative : alternatives) {
//            System.out.println(alternative);
//        }
//    }
    @Deprecated
    public void refreshMapsAlternative() {
        for (int i = 0; i < alternatives.size(); i++) {
            Alternative alternative = alternatives.get(i);
            Map map = new HashMap();
            for (int j = 0; j < alternatives.size(); j++) {
                if (!alternative.equals(alternatives.get(j))) {
                    if (alternative.getMarks().isEmpty()) {
                        map.put(alternatives.get(j), 0.0);
                    } else {
                        if (alternative.getMarks().containsKey(alternatives.get(j))) {
                            map.put(alternatives.get(j), alternative.getMark(alternatives.get(j)));
                        } else {
                            map.put(alternatives.get(j), 0.0);
                        }
                    }
                }
            }
            alternatives.get(i).setMarks(map);
        }
    }

    @Deprecated
    public void refreshMapsCriteria() {
        for (int i = 0; i < criterias.size(); i++) {
            Criteria criteria = criterias.get(i);
            Map map = new HashMap();
            for (int j = 0; j < criterias.size(); j++) {
                if (!criteria.equals(criterias.get(j))) {
                    if (criteria.getMarks().isEmpty()) {
                        map.put(criterias.get(j), 0.0);
                    } else {
                        if (criteria.getMarks().containsKey(criterias.get(j))) {
                            map.put(criterias.get(j), criteria.getMark(criterias.get(j)));
                        } else {
                            map.put(criterias.get(j), 0.0);
                        }
                    }
                }
            }
            criterias.get(i).setMarks(map);
        }
    }

    public void refreshData() {
        for (int i = 0; i < goal.getListCriteria().size(); i++) {
            for (int j = 0; j < goal.getListCriteria().size(); j++) {
                if (!goal.getListCriteria().get(i).equals(goal.getListCriteria().get(j))) {
                    if (!goal.getCriteriaWeights().contains(new CriteriaWeight(goal, goal.getListCriteria().get(i), goal.getListCriteria().get(j), 0, 0))) {
                        goal.getCriteriaWeights().add(new CriteriaWeight(goal, goal.getListCriteria().get(i), goal.getListCriteria().get(j), 0, 0));
                    }
                }
            }

        }
        for (int i = 0; i < goal.getListCriteria().size(); i++) {
            for (int j = 0; j < goal.getListAlternative().size(); j++) {
                for (int k = 0; k < goal.getListAlternative().size(); k++) {
                    if (!goal.getListAlternative().get(j).equals(goal.getListAlternative().get(k))) {
                        if (!goal.getListCriteria().get(i).getAllAlternativeRanks().contains(
                                new AlternativeRanks(goal.getListCriteria().get(i), goal.getListAlternative().get(j), goal.getListAlternative().get(k), 0, 0))) {
                            goal.getListCriteria().get(i).getAllAlternativeRanks().add(new AlternativeRanks(goal.getListCriteria().get(i), goal.getListAlternative().get(j), goal.getListAlternative().get(k), 0, 0));
                        }
                    }
                }
            }
        }
    }

    public void refreshProjectPreview() {
        project = new DefaultMutableTreeNode(goal.getName());
        for (int i = 0; i < goal.getListCriteria().size(); i++) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(goal.getListCriteria().get(i).getName());
            project.add(child);
        }
        DefaultTreeModel dtm = new DefaultTreeModel(project);
        glavnaForma.getTreeViewProject().setModel(dtm);
        
        StringBuilder txtArea = new StringBuilder();
        for (int i = 0; i < goal.getListAlternative().size(); i++) {
            txtArea.append(goal.getListAlternative().get(i).getName()).append(" - ").append(goal.getListAlternative().get(i).getDescription()).append("\n");
        }
        glavnaForma.getTxtAViewAlternatives().setText(txtArea.toString());
    }

    /**
     * @return the glavnaForma
     */
    public FrmMain getGlavnaForma() {
        return glavnaForma;
    }

    /**
     * @param glavnaForma the glavnaForma to set
     */
    public void setGlavnaForma(FrmMain glavnaForma) {
        this.glavnaForma = glavnaForma;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.criteriarating;

import view.renderer.MyRenderer;

/**
 *
 * @author Ivan
 */
public class PnlCriteriasMarks extends javax.swing.JPanel {

    /**
     * Creates new form PnlCriteriasMarks
     */
    public PnlCriteriasMarks() {
        initComponents();
        tblCriteriasMarks.setDefaultRenderer(Object.class, new MyRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCriteriasMarks = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout(1, 0));

        tblCriteriasMarks.setModel(new TblModelCriterias());
        jScrollPane1.setViewportView(tblCriteriasMarks);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCriteriasMarks;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the tblCriteriasMarks
     */
    public javax.swing.JTable getTblCriteriasMarks() {
        return tblCriteriasMarks;
    }

    /**
     * @param tblCriteriasMarks the tblCriteriasMarks to set
     */
    public void setTblCriteriasMarks(javax.swing.JTable tblCriteriasMarks) {
        this.tblCriteriasMarks = tblCriteriasMarks;
    }
}
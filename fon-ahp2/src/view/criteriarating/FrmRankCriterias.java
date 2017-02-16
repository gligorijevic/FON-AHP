/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.criteriarating;

import controller.criteria.weights.ControllerCriteriaWeights;
import data.ACStorage;
import exception.MarkNotInSatScaleException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;
import javax.swing.table.TableModel;

/**
 *
 * @author Ivan
 */
public class FrmRankCriterias extends javax.swing.JDialog {
    
    private JPanel panelCA;

    /**
     * Creates new form JDialogCA
     */
    public FrmRankCriterias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cBox = (String) cmbNormalize.getSelectedItem();
    }
    public String cBox;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOptions = new javax.swing.JPanel();
        btnCalculate = new javax.swing.JButton();
        btnNormalize = new javax.swing.JButton();
        lblChooseNormalization = new javax.swing.JLabel();
        cmbNormalize = new javax.swing.JComboBox();
        pnlSlider = new javax.swing.JPanel();
        slderWeightCriterias = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        pnlOptions.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlOptions.setPreferredSize(new java.awt.Dimension(581, 84));

        btnCalculate.setText("Calculate");
        btnCalculate.setMaximumSize(new java.awt.Dimension(49, 23));
        btnCalculate.setMinimumSize(new java.awt.Dimension(49, 23));
        btnCalculate.setPreferredSize(new java.awt.Dimension(49, 23));
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        btnNormalize.setText("Normalize");
        btnNormalize.setAlignmentX(5.0F);
        btnNormalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalizeActionPerformed(evt);
            }
        });

        lblChooseNormalization.setText("Choose type of normalization for criteria weights:");
        lblChooseNormalization.setMaximumSize(new java.awt.Dimension(247, 14));
        lblChooseNormalization.setMinimumSize(new java.awt.Dimension(247, 14));
        lblChooseNormalization.setPreferredSize(new java.awt.Dimension(247, 14));

        cmbNormalize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L1Normalization", "L2Normalization", "LInfinityNormalization", "BestWorstNormalization" }));

        javax.swing.GroupLayout pnlOptionsLayout = new javax.swing.GroupLayout(pnlOptions);
        pnlOptions.setLayout(pnlOptionsLayout);
        pnlOptionsLayout.setHorizontalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                        .addComponent(lblChooseNormalization, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNormalize, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNormalize, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlOptionsLayout.setVerticalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNormalize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNormalize)
                    .addComponent(lblChooseNormalization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlOptions, java.awt.BorderLayout.PAGE_END);

        pnlSlider.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlSlider.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlSlider.setPreferredSize(new java.awt.Dimension(581, 61));
        pnlSlider.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slderWeightCriterias.setMajorTickSpacing(1);
        slderWeightCriterias.setMaximum(8);
        slderWeightCriterias.setMinimum(-8);
        slderWeightCriterias.setPaintTicks(true);
        slderWeightCriterias.setSnapToTicks(true);
        slderWeightCriterias.setValue(0);
        slderWeightCriterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slderWeightCriteriasMouseReleased(evt);
            }
        });
        slderWeightCriterias.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slderWeightCriteriasStateChanged(evt);
            }
        });
        pnlSlider.add(slderWeightCriterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 7, 510, -1));

        jLabel1.setText("     9        8        7         6        5         4        3        2        1         2        3         4        5        6         7        8        9");
        pnlSlider.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 540, -1));

        getContentPane().add(pnlSlider, java.awt.BorderLayout.PAGE_START);

        pnlTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Criteria weights"));
        pnlTable.setMinimumSize(new java.awt.Dimension(12, 23));
        pnlTable.setPreferredSize(new java.awt.Dimension(12, 23));
        pnlTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalculateActionPerformed
    
    private void slderWeightCriteriasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slderWeightCriteriasStateChanged
//        try {
//            TblModelCriterias tblModel = (TblModelCriterias) ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getModel();
//            int columnIndex = ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedColumn();
//            int rowIndex = ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedRow();
//
//            ACStorage.getInstance().getGoal().addCriteriaWeight(ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex), ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1), Math.abs(jSlider1.getValue()) + 1);
//            ACStorage.getInstance().getGoal().addCriteriaWeight(ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1), ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex), (1 / (Math.abs(jSlider1.getValue()) + 1)));
//            //  linija 149 treba da polje ispod dijagonale promeni reciprocno. 
//            tblModel.fireTableDataChanged();
//        } catch (MarkNotInSatScaleException ex) {
//            Logger.getLogger(FrmRankCriterias.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_slderWeightCriteriasStateChanged
    
    private void slderWeightCriteriasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slderWeightCriteriasMouseReleased
        if (((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedColumn() > -1
                && ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedRow() > -1) {
            try {
                TblModelCriterias tblModel = (TblModelCriterias) ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getModel();
                int columnIndex = ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedColumn();
                int rowIndex = ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().getSelectedRow();
                System.out.println("Selected row: " + rowIndex + " ,select column: " + columnIndex);
                if (slderWeightCriterias.getValue() >= 0) {
                    ACStorage.getInstance().getGoal().addCriteriaWeight(
                            ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1),
                            ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex),
                            Math.abs(slderWeightCriterias.getValue()) + 1);
                    ACStorage.getInstance().getGoal().addCriteriaWeight(
                            ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex),
                            ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1),
                            (1.0 / (Math.abs(slderWeightCriterias.getValue()) + 1)));
                    tblModel.fireTableDataChanged();
                } else {
                    ACStorage.getInstance().getGoal().addCriteriaWeight(
                            ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1),
                            ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex),
                            (1.0 / (Math.abs(slderWeightCriterias.getValue()) + 1)));
                    ACStorage.getInstance().getGoal().addCriteriaWeight(
                            ACStorage.getInstance().getGoal().getListCriteria().get(rowIndex),
                            ACStorage.getInstance().getGoal().getListCriteria().get(columnIndex - 1),
                            Math.abs(slderWeightCriterias.getValue()) + 1);
                    tblModel.fireTableDataChanged();
                }
            } catch (MarkNotInSatScaleException ex) {
                Logger.getLogger(FrmRankCriterias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        slderWeightCriterias.setValue(0);
    }//GEN-LAST:event_slderWeightCriteriasMouseReleased
    
    private void btnNormalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNormalizeActionPerformed
        cBox = (String) cmbNormalize.getSelectedItem();
        try {
            ControllerCriteriaWeights.getInstance().normalize(cBox, ACStorage.getInstance().getGoal());
            TblModelNormalizedCriterias tblModelNormalizedCriterias = new TblModelNormalizedCriterias(
                    ACStorage.getInstance().getGoal());
            ((PnlCriteriasMarks) pnlTable).getTblCriteriasMarks().setModel(tblModelNormalizedCriterias);
            slderWeightCriterias.setEnabled(false);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnNormalizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRankCriterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRankCriterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRankCriterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRankCriterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRankCriterias dialog = new FrmRankCriterias(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnNormalize;
    private javax.swing.JComboBox cmbNormalize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChooseNormalization;
    private javax.swing.JPanel pnlOptions;
    private javax.swing.JPanel pnlSlider;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JSlider slderWeightCriterias;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the panelCA
     */
    public JPanel getPanelCA() {
        return panelCA;
    }

    /**
     * @param panelCA the panelCA to set
     */
    public void setPanelCA(JPanel panelCA) {
        this.panelCA = panelCA;
        repaint();
        pack();
    }
    
    public void setActivePanel(JPanel noviPanel) {
        if (pnlTable != null) {
            this.remove(pnlTable);
        }
        
        pnlTable = noviPanel;
        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);
        pnlTable.setVisible(true);
        validate();
        repaint();
        pack();
    }
    
    
}
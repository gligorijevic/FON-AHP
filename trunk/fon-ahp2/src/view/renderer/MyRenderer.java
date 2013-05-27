/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marko
 */
public class MyRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0) {
            c.setBackground(Color.CYAN);
        } else if (column == row + 1) {
            c.setBackground(Color.lightGray);
        } else {
            c.setBackground(Color.yellow);
        }
        table.getTableHeader().setBackground(Color.CYAN);
        return c;
    }
}

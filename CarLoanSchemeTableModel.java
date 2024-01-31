import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class CarLoanSchemeTableModel extends AbstractTableModel {

    private final Object[][] data;
    private final String[] columnNames;

    public CarLoanSchemeTableModel(Object[][] data, String[] columnNames) {
        super();
        this.data = data;
        this.columnNames = columnNames;
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    /** Makes all the cell uneditable. */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

}

import javax.swing.table.AbstractTableModel;

public class CarLoanTableModel extends AbstractTableModel {

    private final Object[][] data;
    private final String[] columnNames;

    public CarLoanTableModel(Object[][] data, String[] columnNames) {
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

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /** Makes all the cell uneditable. */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

}

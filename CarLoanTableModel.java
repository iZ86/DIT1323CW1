import javax.swing.table.AbstractTableModel;

/** The table model class used in the Kawaguchi Bank Car Loan Application,
 * that extends the AbstractTableModel.
 */
public class CarLoanTableModel extends AbstractTableModel {
    /** Table data. */
    private final Object[][] data;
    /** Table column. */
    private final String[] columnNames;

    /** Constructs a default CarLoanTableModel which is a with String[] columnNames,
     * and Object[][] data.
     */
    public CarLoanTableModel(Object[][] data, String[] columnNames) {
        super();
        this.data = data;
        this.columnNames = columnNames;
    }

    /** Return the number of rows in the model. */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /** Return the number of columns in the model. */
    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    /** Return the value for the cell at rowIndex and columnIndex. */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    /** Returns a default name for the column,
     * using spreadsheet conventions: A, B, C, ... Z, AA, AB, etc.
     * If column cannot be found,
     * returns an empty string.
     */
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

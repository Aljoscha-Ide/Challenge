package de.gamomat.challenge.slotmachine.data;

public class WinSymbol {
    private Symbol symbol;
    //Yes indices are really complicated here, check the initialization in the unit test,
    //but it enables very complex winlines and specific modifier.
    //Maybe additional, general winlines for just three symbols in a row would be useful.
    private Integer rowIndex;
    private Integer columnIndex;

    public WinSymbol(Symbol symbol, Integer rowIndex, Integer columnIndex) {
        this.symbol = symbol;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(final Symbol symbol) {
        this.symbol = symbol;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(final Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(final Integer columnIndex) {
        this.columnIndex = columnIndex;
    }
}

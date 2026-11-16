package com.dato.cafe.exception;

public class OccupiedTableException extends CafeException {
    private final int tableId;

    public OccupiedTableException(int tableId) {
        super("Table " + tableId + " is already occupied");
        this.tableId = tableId;
    }

    public int getTableID() { return this.tableId; }
}

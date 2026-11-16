package com.dato.cafe.model;

import com.dato.cafe.enums.TableStatus;

public class Table {
    private final int tableId;
    private TableStatus status;
    private final int capacity;

    public Table(int tableId, TableStatus status, int capacity){
        this.tableId = tableId;
        this.status = status;
        this.capacity = capacity;
    }

    public int getTableId(){ return this.tableId; }

    public TableStatus getStatus() { return this.status; }

    public int getCapacity() { return this.capacity; }

    public void occupy() {
        this.status = TableStatus.OCCUPIED;
    }

    public void release() {
        this.status = TableStatus.FREE;
    }
}

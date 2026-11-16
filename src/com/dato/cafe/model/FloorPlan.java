package com.dato.cafe.model;

import com.dato.cafe.enums.TableStatus;
import com.dato.cafe.exception.OccupiedTableException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloorPlan {
    private final Map<Integer, Table> tables = new HashMap<>();

    public Table findTable(int id){
        return tables.get(id);
    }

    public void addTable(Table table){
        tables.put(table.getTableId(), table);
    }

    public List<Table> getFreeTables() {
        List<Table> freeTables = new ArrayList<>();
        for (Table table : tables.values()){
            if (table.getStatus() == TableStatus.FREE) { freeTables.add(table); }
        }
        return freeTables;
    }

    public List<Integer> getFreeTableIDs() {
        List<Table> freeTables = getFreeTables();
        List<Integer> freeTableIDs = new ArrayList<>();

        for (Table table : freeTables) {
            freeTableIDs.add(table.getTableId());
        }
        return freeTableIDs;
    }

    public List<Table> getOccupiedTables() {
        List<Table> occupiedTables = new ArrayList<>();
        for (Table table : tables.values()) {
            if (table.getStatus() == TableStatus.OCCUPIED) { occupiedTables.add(table); }
        }
        return occupiedTables;
    }

    public void occupyTable(int tableId) throws OccupiedTableException {
        Table table = findTable(tableId);
        if (table.getStatus() == TableStatus.OCCUPIED) {
            throw new OccupiedTableException(tableId);
        }
        table.occupy();
    }

}

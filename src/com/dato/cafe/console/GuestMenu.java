package com.dato.cafe.console;

import com.dato.cafe.exception.OccupiedTableException;
import com.dato.cafe.model.FloorPlan;
import com.dato.cafe.model.Menu;
import com.dato.cafe.model.Table;

import java.util.List;
import java.util.Scanner;

public class GuestMenu {
    private final FloorPlan floorPlan;
    private final Menu menu;
    private final Scanner scanner;


    public GuestMenu(FloorPlan floorPlan, Menu menu, Scanner scanner) {
        this.floorPlan = floorPlan;
        this.menu = menu;
        this.scanner = scanner;
    }

    private void showMenu() {
        menu.printMenu();
        String choice = scanner.nextLine().trim();
        if (choice.equals("0")){ return; }
    }

    public void show() {
        System.out.println("Welcome to our cafe!");
        List<Table> free = floorPlan.getFreeTables();

        if (free.isEmpty()) {
            System.out.println("Sorry, no free tables right now.");
            return;
        }

        System.out.println("Choose a table:");
        for (Table t : free) {
            System.out.println(t.getTableId() + ". Table for " + t.getCapacity());
        }
        System.out.println("0. Exit");
        System.out.print("> ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("0")){ return; }

        int chosenTableId;
        try {
            chosenTableId = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
            return;
        }

        try {
            floorPlan.occupyTable(chosenTableId);
            showMenu();
        } catch (OccupiedTableException e) {
            System.out.println(e.getMessage());
        }

    }
}

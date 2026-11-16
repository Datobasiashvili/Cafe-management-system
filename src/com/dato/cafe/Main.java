package com.dato.cafe;

import com.dato.cafe.console.ConsoleApp;
import com.dato.cafe.enums.Category;
import com.dato.cafe.enums.TableStatus;
import com.dato.cafe.model.*;

public class Main {
    public static void main(String[] args) {
        FloorPlan plan = new FloorPlan();
        plan.addTable(new Table(1, TableStatus.FREE, 2));
        plan.addTable(new Table(2, TableStatus.FREE, 4));
        plan.addTable(new Table(3, TableStatus.FREE, 2));

        Menu menu = new Menu();
        menu.addMenuItem(Category.FOOD, new Food("Burger", 15));
        menu.addMenuItem(Category.DRINK, new Drink("Pepsi", 3));
        menu.addMenuItem(Category.FOOD, new Food("French Fries", 7));

        new ConsoleApp(plan, menu).run();
    }
}
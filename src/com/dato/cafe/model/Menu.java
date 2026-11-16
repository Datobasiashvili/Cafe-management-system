package com.dato.cafe.model;

import com.dato.cafe.enums.Category;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final Map<Category, List<MenuItem>> menuItemMap = new EnumMap<>(Category.class);
    private final List<MenuItem> numberedItems = new ArrayList<>();

    public void addMenuItem(Category category, MenuItem menuItem){
        menuItemMap.computeIfAbsent(category, c -> new ArrayList<>()).add(menuItem);
    }

    public void printMenu() {
        numberedItems.clear();
        int number = 1;
        String line = "=".repeat(42);

        System.out.println(line);
        System.out.println("                  MENU");
        System.out.println(line);

        for (Map.Entry<Category, List<MenuItem>> entry : menuItemMap.entrySet()) {
            System.out.println("\n--- " + entry.getKey() + " ---");

            for (MenuItem item : entry.getValue()) {
                System.out.printf("%2d. %-25s %7d ₾%n", number, item.getName(), item.getPrice());
                numberedItems.add(item);
                number++;
            }
        }

        System.out.println("\n" + line);
        System.out.printf("%2d. %s%n", 0, "Exit / Finish order");
        System.out.println(line);
    }

    public MenuItem getItemByNumber(int number) {
        if (number < 1 || number > numberedItems.size()) {
            return null;
        }
        return numberedItems.get(number - 1);
    }
}

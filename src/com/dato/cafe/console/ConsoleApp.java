package com.dato.cafe.console;

import com.dato.cafe.model.FloorPlan;
import com.dato.cafe.model.Menu;

import java.util.Scanner;

public class ConsoleApp {
    private final Scanner scanner = new Scanner(System.in);
    private final GuestMenu guestMenu;

    public ConsoleApp(FloorPlan floorPlan, Menu menu){
        this.guestMenu = new GuestMenu(floorPlan, menu, scanner);
    }

    public void run(){
        boolean running = true;
        while (running) {
            System.out.println("--- Cafe System ---");
            System.out.println("1. Log in");
            System.out.println("2. Guest");
            System.out.println("0. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> System.out.println("Login not implemented");
                case "2" -> guestMenu.show();
                case "0" -> running = false;
                default -> System.out.println("Invalid option, try again!");
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }


}

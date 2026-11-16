package com.dato.cafe.model;

public abstract class MenuItem {
    private final String name;
    private int price;

    protected MenuItem (String name, int price) {
        this.name = name;
        this.price = price;
    }

    protected String getName() { return this.name; }
    protected int getPrice() { return this.price; }
    protected void setPrice(int newPrice) { this.price = newPrice; }
}

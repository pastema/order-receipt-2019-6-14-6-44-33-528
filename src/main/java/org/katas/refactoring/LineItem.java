package org.katas.refactoring;

public class LineItem {
    private String description;
    private double pieces;
    private int quantity;

    public LineItem(String description, double pieces, int quantity) {
        super();
        this.description = description;
        this.pieces = pieces;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return pieces;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return pieces * quantity;
    }
}
package org.katas.refactoring;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Order {
    String name;
    String address;
    List<LineItem> lineItem;

    public Order(String name, String address, List<LineItem> lineItem) {
        this.name = name;
        this.address = address;
        this.lineItem = lineItem;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItem;
    }

    public String getDate() {
        return LocalDate.now().toString();
    }

    public String getCustomerLoyaltyNumber() {
        return  UUID.randomUUID().toString();
    }
}

package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private double totalSalesTax = 0d;
    private double totalAmount = 0d;
    private Character tab = '\t';
    private Character newLine = '\n';

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        PrintHeaders(output);

        // prints lineItems
        PrintsLineItems(output);

        // prints the state tax
        PrintTheStateTax(output);

        // print total amount
        PrintTotalAmount(output);
        return output.toString();
    }

    private void PrintTotalAmount(StringBuilder output) {
        output.append("Total Amount").append(tab).append(totalAmount);
    }

    private void PrintTheStateTax(StringBuilder output) {
        output.append("Sales Tax").append(tab).append(totalSalesTax);
    }

    private void PrintsLineItems(StringBuilder output) {

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(tab);
            output.append(lineItem.getPrice());
            output.append(tab);
            output.append(lineItem.getQuantity());
            output.append(tab);
            output.append(lineItem.totalAmount());
            output.append(newLine);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }
    }

    private void PrintHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        output.append("Date - " + order.getDate());
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        output.append(order.getCustomerLoyaltyNumber());
    }
}
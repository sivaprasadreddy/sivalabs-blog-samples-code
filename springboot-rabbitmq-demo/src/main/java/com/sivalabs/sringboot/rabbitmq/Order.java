package com.sivalabs.sringboot.rabbitmq;

import java.io.Serializable;

public class Order implements Serializable{
    private String orderNumber;
    private String productId;
    private double amount;

    public Order() {
    }

    public Order(String orderNumber, String productId, double amount) {
        this.orderNumber = orderNumber;
        this.productId = productId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

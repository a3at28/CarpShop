package tech.itpark.carpshop.model;

import lombok.Value;

@Value

public class Order {
    long id;
    long clientId;
    boolean payment;
    long boilId;
    String name;
    int quantity;
    String imageURL;
    int order_price;
}
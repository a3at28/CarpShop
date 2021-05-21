package tech.itpark.carpshop.model;

import lombok.Value;

@Value

public class Boil {
        long id;
        long manufacturerId;
        String name;
        int diameter;
        int weight;
        int quantity;
        String imageURL;
        int price;
}

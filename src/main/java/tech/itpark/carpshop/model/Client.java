package tech.itpark.carpshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Client {
    private long id;
    private String name;
    private String number;
    private String email;
    private String shipping_address;
}

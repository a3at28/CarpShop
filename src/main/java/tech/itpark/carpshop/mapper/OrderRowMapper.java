package tech.itpark.carpshop.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.carpshop.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getLong("clientId"),
                rs.getBoolean("payment"),
                rs.getLong("boilId"),
                rs.getString("name"),
                rs.getInt("quantity"),
                rs.getString("imageURL"),
                rs.getInt("order_price")
        );
    }
}

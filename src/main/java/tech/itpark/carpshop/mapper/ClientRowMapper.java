package tech.itpark.carpshop.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.carpshop.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    public Client mapRow(ResultSet rs, int rowNumb) throws SQLException {
        return new Client(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("number"),
                rs.getString("email"),
                rs.getString("shipping_address")
                );
    }
}

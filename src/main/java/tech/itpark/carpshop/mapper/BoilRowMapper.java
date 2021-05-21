package tech.itpark.carpshop.mapper;

import org.springframework.jdbc.core.RowMapper;

import tech.itpark.carpshop.model.Boil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoilRowMapper implements RowMapper<Boil> {
    public Boil mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Boil(
                rs.getLong("id"),
                rs.getLong("manufacturer_id"),
                rs.getString("name"),
                rs.getInt("diameter"),
                rs.getInt("weight"),
                rs.getInt("quantity"),
                rs.getString("imageURL"),
                rs.getInt("price")
        );
    }
}

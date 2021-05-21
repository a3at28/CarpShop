package tech.itpark.carpshop.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.carpshop.mapper.BoilRowMapper;
import tech.itpark.carpshop.model.Boil;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BoilManager {
    private final NamedParameterJdbcTemplate template;
    private final BoilRowMapper rowMapper = new BoilRowMapper();

    public List<Boil> getAll() {
        return template.query(
                "SELECT id, manufacturer_id, name, diameter, weight, quantity, imageURL, price FROM boils ORDER BY id LIMIT 50",
                rowMapper
        );
    }

    public  Boil getById(long id) {
        return template.queryForObject(
                "SELECT id, manufacturer_id, name, diameter, weight, quantity, imageURL, price FROM boils WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public List<Boil> getByManufacturerId(long manufacturerId) {
        return template.query(
                "SELECT id, manufacturer_id, name, diameter, weight, quantity, imageURL, price FROM boils WHERE manufacturer_id = :manufacturer_id",
                Map.of("manufacturer_id", manufacturerId),
                rowMapper
        );
    }

    public Boil save(Boil item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO boils(manufacturer_id, name, diameter, quantity, weight, imageURL, price) VALUES (:manufacturer_id, :name, :diameter, :weight, :quantity, :imageURL, :price)",
                    new MapSqlParameterSource(Map.of(
                            "manufacturer_id", item.getManufacturerId(),
                            "name", item.getName(),
                            "diameter", item.getDiameter(),
                            "weight", item.getWeight(),
                            "quantity", item.getQuantity(),
                            "imageURL", item.getImageURL(),
                            "price", item.getPrice()
                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update(
                "UPDATE boils SET manufacturer_id = :manufacturer_id, name = :name, diameter = :diameter, weight = :weight, quantity = :quantity, imageURL = :imageURL, price = :price WHERE id = :id",
                (Map.of(
                        "id", item.getId(),
                        "manufacturer_id", item.getManufacturerId(),
                        "name", item.getName(),
                        "diameter", item.getDiameter(),
                        "weight", item.getWeight(),
                        "quantity", item.getQuantity(),
                        "imageURL", item.getImageURL(),
                        "price", item.getPrice()
                ))
        );

        return getById(item.getId());
    }

    public Boil removeById(long id) {
        Boil item = getById(id);

        template.update(
                "DELETE FROM boils WHERE id = :id",
                Map.of("id", item.getId())
                );

        return item;
    }


    public Boil search(String name) {
        return template.queryForObject(
                "SELECT id, manufacturer_id, name, diameter, weight, quantity, imageURL, price FROM boils WHERE name = :name",
                Map.of("name", name),
                rowMapper
        );
    }
}


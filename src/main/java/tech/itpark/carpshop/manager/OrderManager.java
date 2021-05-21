package tech.itpark.carpshop.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.carpshop.mapper.OrderRowMapper;
import tech.itpark.carpshop.model.Order;
import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class OrderManager {
    private final NamedParameterJdbcTemplate template;
    private final OrderRowMapper rowMapper = new OrderRowMapper();

    public List<Order> getAll() {
        return template.query(
                "SELECT id, client_id, payment, boil_id, name, quantity, imageURL, order_price FROM orders ORDER BY id LIMIT 10",
                rowMapper
        );
    }

    public Order getByOrderId(long id) {
        return template.queryForObject(
                "SELECT id, client_id, payment, boil_id, name, quantity, imageURL, order_price FROM orders WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public Order save(Order dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO orders(client_id, payment, boil_id, name, quantity, imageURL, order_price) VALUES (:client_id, :payment, :boil_id, :name, :quantity, :imageURL, :order_price)",
                new MapSqlParameterSource(Map.of(
                        "client_id", dto.getClientId(),
                        "payment", dto.isPayment(),
                        "boil_id", dto.getBoilId(),
                        "name", dto.getName(),
                        "quantity", dto.getQuantity(),
                        "imageURL", dto.getImageURL(),
                        "order_price", dto.getImageURL()
                )),
                keyHolder
        );
        return dto;
    }

    public  Order update( Order dto) {
        template.update(
                "UPDATE orders SET client_id = :client_id, payment = :payment, boil_id = :boil_id, name = :name, quantity = :quantity, imageURL = :imageURL, order_price = :order_price  WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "client_id", dto.getClientId(),
                        "payment", dto.isPayment(),
                        "boil_id", dto.getBoilId(),
                        "name", dto.getName(),
                        "quantity", dto.getQuantity(),
                        "imageURL", dto.getImageURL(),
                        "order_price", dto.getImageURL()
                )
        );
        return getByOrderId(dto.getId());
    }

    public Order removeById(long id) {
        Order dto = getByOrderId(id);

        template.update(
                "DELETE FROM orders WHERE id = :id",
                Map.of("id", dto.getId())
        );

        return dto;
    }

    public Order search(String name) {
        return template.queryForObject(
                "SELECT id, client_id, payment, boil_id, name, quantity, imageURL, order_price FROM orders WHERE name = :name",
                Map.of("name", name),
                rowMapper
        );
    }
}




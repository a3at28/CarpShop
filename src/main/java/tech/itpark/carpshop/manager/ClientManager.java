package tech.itpark.carpshop.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.carpshop.mapper.ClientRowMapper;
import tech.itpark.carpshop.model.Client;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ClientManager {
    private final NamedParameterJdbcTemplate template;
    private final ClientRowMapper rowMapper = new ClientRowMapper();

    public List<Client> getAll() {
        return template.query(
                "SELECT id, name, number, email, shipping_address FROM client ORDER BY id LIMIT 10",
                rowMapper
        );
    }

    public Client getByBuyerId(long id) {
        return template.queryForObject(
                "SELECT id, name, number, email, shipping_address FROM client WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public Client save(Client dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                "INSERT INTO client(name, number, email, shipping_address) VALUES (:name, :number, :email, :shipping_address)",
                new MapSqlParameterSource(Map.of(
                        "name", dto.getName(),
                        "number", dto.getNumber(),
                        "email", dto.getEmail(),
                        "shipping_address", dto.getShipping_address()
                )),
                keyHolder
        );
        return dto;
    }

    public  Client update( Client dto) {
        template.update(
                "UPDATE client SET name = :name, number = :number, email = :email, shipping_address = :shipping_address WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "name", dto.getName(),
                        "number", dto.getNumber(),
                        "email", dto.getEmail(),
                        "shipping_address", dto.getShipping_address()
                )
        );
        return getByBuyerId(dto.getId());
    }
}

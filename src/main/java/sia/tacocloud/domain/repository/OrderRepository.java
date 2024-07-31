package sia.tacocloud.domain.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.dto.TacoOrder;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}

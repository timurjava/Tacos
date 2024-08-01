package sia.tacocloud.domain.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.dto.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
    TacoOrder save(TacoOrder order);
}

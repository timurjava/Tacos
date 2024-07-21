package sia.tacocloud.domain.repository;

import sia.tacocloud.domain.dto.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}

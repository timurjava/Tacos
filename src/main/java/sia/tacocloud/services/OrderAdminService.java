package sia.tacocloud.services;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.repository.OrderRepository;

@Service
public class OrderAdminService {
    @Resource
    OrderRepository orderRepository;
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}

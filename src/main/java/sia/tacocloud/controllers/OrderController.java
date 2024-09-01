package sia.tacocloud.controllers;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.domain.dto.TacoOrder;
import sia.tacocloud.domain.repository.OrderRepository;
import sia.tacocloud.domain.security.User;
//import sia.tacocloud.services.OrderAdminService;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @Resource
    private OrderRepository orderRepository;
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }
    @PostMapping
    public String processOrder (@Valid TacoOrder tacoOrder, Errors errors,
                                SessionStatus sessionStatus,
                                @AuthenticationPrincipal User user) {
        if (errors.hasErrors()){
            return "orderForm";
        }
        tacoOrder.setUser(user);
        orderRepository.save(tacoOrder);
        log.info("Order submitted : {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/design";
    }
}

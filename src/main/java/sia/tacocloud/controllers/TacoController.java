package sia.tacocloud.controllers;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.domain.dto.Taco;
import sia.tacocloud.domain.dto.TacoOrder;
import sia.tacocloud.domain.repository.OrderRepository;
import sia.tacocloud.domain.repository.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/tacos",
        produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080")
public class TacoController {
    private TacoRepository tacoRepo;
    private OrderRepository orderRepository;
    public TacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }
    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createAt").descending());
        return tacoRepo.findAll(page).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
    @PutMapping(path="/{orderId}", consumes="application/json")
    public TacoOrder putOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody TacoOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Exception");
        }
        return ResponseEntity.notFound().build();
    }
}

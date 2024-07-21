package sia.tacocloud.controllers;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.domain.dto.Ingredient;
import sia.tacocloud.domain.dto.IngredientType;
import sia.tacocloud.domain.dto.Taco;
import sia.tacocloud.domain.dto.TacoOrder;
import sia.tacocloud.domain.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    @Resource
    private IngredientRepository jdbcIngredientRepository;
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = jdbcIngredientRepository.findAll();
        IngredientType [] types = IngredientType.values();
        for (IngredientType type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute
    public Taco taco() {
        return new Taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if(errors.hasErrors()) {
            return "design";
        }
        log.info("Processing Taco: {}", taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, IngredientType type) {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredients.forEach(x -> {
            if (x.type().equals(type)){
                ingredientList.add(x);
            }
        });
        return ingredientList;
    }
}

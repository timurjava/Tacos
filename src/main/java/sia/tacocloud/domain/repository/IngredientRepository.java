package sia.tacocloud.domain.repository;

import sia.tacocloud.domain.dto.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save (Ingredient ingredient);
}

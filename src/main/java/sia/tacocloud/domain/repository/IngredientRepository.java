package sia.tacocloud.domain.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.dto.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

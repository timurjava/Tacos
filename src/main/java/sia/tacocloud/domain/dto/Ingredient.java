package sia.tacocloud.domain.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("INGREDIENT")
public record Ingredient(@Id String id, String name, IngredientType type) implements Persistable<String> {

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
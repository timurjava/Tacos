package sia.tacocloud.utils;

import sia.tacocloud.domain.dto.Ingredient;
import sia.tacocloud.domain.util.IngredientUDT;

public class TacoUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}

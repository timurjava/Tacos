package sia.tacocloud.utils;


import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sia.tacocloud.domain.dto.Ingredient;
import sia.tacocloud.domain.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    @Resource
    private IngredientRepository jdbcIngredientRepository;
    @Override
    public Ingredient convert(String id) {
        return jdbcIngredientRepository.findById(id).orElse(null);
    }
}

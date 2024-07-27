package sia.tacocloud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import sia.tacocloud.domain.dto.Ingredient;
import sia.tacocloud.domain.dto.IngredientType;
import sia.tacocloud.domain.repository.IngredientRepository;

@Configuration
public class DatabaseDataConfig {
//    @Bean
//    public CommandLineRunner dataLoader(IngredientRepository repo) {
//    Бин который позволяет после включения всех
//    компонентов спринга но до любых других событий загрузить в базу первоначальные данные принимает на вход аргументы
//    командной строки разница с бином ниже в том что не умеет работать с поиском по аргументам поиск придётся писать
//    самому
//        return args -> {
//            repo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
//            repo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
//            repo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
//            repo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
//            repo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
//            repo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
//            repo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
//            repo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
//            repo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
//            repo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
//        };
//    }
    @Autowired
    JdbcAggregateTemplate repo;

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
        return args -> {
            //List<String> version = args.getOptionValues("version"); метод поиска по агрументамб возврашает список
            // так как одному значению может соответствовать несколько элемнтов
            repo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
        };
    }
}

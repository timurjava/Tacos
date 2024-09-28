package sia.tacocloud.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.domain.dto.Ingredient;
import sia.tacocloud.domain.dto.IngredientType;
import sia.tacocloud.domain.dto.Taco;
import sia.tacocloud.domain.repository.IngredientRepository;
import sia.tacocloud.domain.repository.TacoRepository;
import sia.tacocloud.domain.repository.UserRepository;

import java.util.Arrays;

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

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo,
                                        UserRepository userRepo,
                                        PasswordEncoder encoder,
                                        TacoRepository tacoRepo)  {
        return args -> {
            //List<String> version = args.getOptionValues("version"); метод поиска по агрументамб возврашает список
            // так как одному значению может соответствовать несколько элемнтов
            Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP);
            Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP);
            Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN);
            Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES);
            Ingredient lettuce = new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES);
            Ingredient cheddar = new Ingredient("CHED", "Cheddar", IngredientType.CHEESE);
            Ingredient jack = new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE);
            Ingredient salsa = new Ingredient("SLSA", "Salsa", IngredientType.SAUCE);
            Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE);
            repo.save(flourTortilla);
            repo.save(cornTortilla);
            repo.save(groundBeef);
            repo.save(carnitas);
            repo.save(tomatoes);
            repo.save(lettuce);
            repo.save(cheddar);
            repo.save(jack);
            repo.save(salsa);
            repo.save(sourCream);
            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                    flourTortilla, groundBeef, carnitas,
                    sourCream, salsa, cheddar));
            tacoRepo.save(taco1);
            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla, groundBeef, cheddar,
                    jack, sourCream));
            tacoRepo.save(taco2);
            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(
                    flourTortilla, cornTortilla, tomatoes,
                    lettuce, salsa));
            tacoRepo.save(taco3);

        };
    }
}

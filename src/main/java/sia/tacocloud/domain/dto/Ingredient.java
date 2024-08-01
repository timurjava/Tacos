package sia.tacocloud.domain.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED, force=true)
public class Ingredient {
    @Id
    private String id;
    private String name;
    private IngredientType type;
}

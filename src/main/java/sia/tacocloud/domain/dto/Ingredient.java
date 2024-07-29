package sia.tacocloud.domain.dto;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED, force=true)
@Table("ingredients")
public class Ingredient {
    @PrimaryKey
    private String id;
    private String name;
    private IngredientType type;
}

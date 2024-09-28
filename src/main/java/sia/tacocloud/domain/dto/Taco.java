package sia.tacocloud.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue
    private long id;
    private Date createAt = new Date();
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    @NotNull
    @Size(min=1, message="You must choose at least one ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;
}

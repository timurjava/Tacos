package sia.tacocloud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.tacocloud.domain.dto.Taco;


public interface TacoRepository extends JpaRepository<Taco, Long> {
}

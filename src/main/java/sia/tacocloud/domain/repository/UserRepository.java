package sia.tacocloud.domain.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.security.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

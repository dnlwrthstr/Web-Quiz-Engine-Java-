package engine.repository;

import engine.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findAppUserByUsername(String username);
    boolean existsAppUserByUsername(String username);

}

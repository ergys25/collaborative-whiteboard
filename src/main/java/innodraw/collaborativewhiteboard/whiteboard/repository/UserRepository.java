package innodraw.collaborativewhiteboard.whiteboard.repository;

import innodraw.collaborativewhiteboard.whiteboard.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    // Additional query methods can be defined here if needed
    Optional<AppUser> findByUsername(String username);

}
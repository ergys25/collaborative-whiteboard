package innodraw.collaborativewhiteboard.whiteboard.repository;

import innodraw.collaborativewhiteboard.whiteboard.model.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, Long> {
    // Additional query methods can be defined here if needed
}
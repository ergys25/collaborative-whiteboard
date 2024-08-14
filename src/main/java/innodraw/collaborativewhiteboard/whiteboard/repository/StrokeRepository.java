package innodraw.collaborativewhiteboard.whiteboard.repository;


import innodraw.collaborativewhiteboard.whiteboard.model.Stroke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrokeRepository extends JpaRepository<Stroke, Long> {
    // Additional query methods can be defined here if needed
}
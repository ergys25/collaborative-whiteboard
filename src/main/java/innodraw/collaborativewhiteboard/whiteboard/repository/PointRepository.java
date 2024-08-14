package innodraw.collaborativewhiteboard.whiteboard.repository;

import innodraw.collaborativewhiteboard.whiteboard.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    // Additional query methods can be defined here if needed
}
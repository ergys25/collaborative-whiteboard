package innodraw.collaborativewhiteboard.whiteboard.controller;

import innodraw.collaborativewhiteboard.whiteboard.model.Point;
import innodraw.collaborativewhiteboard.whiteboard.service.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<Point> getAllPoints() {
        return pointService.getAllPoints();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Point> getPointById(@PathVariable Long id) {
        Optional<Point> point = pointService.getPointById(id);
        return point.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Point createPoint(@RequestBody Point point) {
        return pointService.createPoint(point);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Point> updatePoint(@PathVariable Long id, @RequestBody Point updatedPoint) {
        return pointService.updatePoint(id, updatedPoint)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoint(@PathVariable Long id) {
        if (pointService.deletePoint(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

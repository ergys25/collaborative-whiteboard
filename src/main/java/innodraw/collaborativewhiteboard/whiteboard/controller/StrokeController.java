package innodraw.collaborativewhiteboard.whiteboard.controller;

import innodraw.collaborativewhiteboard.whiteboard.model.Stroke;
import innodraw.collaborativewhiteboard.whiteboard.service.StrokeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/strokes")
public class StrokeController {

    private final StrokeService strokeService;

    public StrokeController(StrokeService strokeService) {
        this.strokeService = strokeService;
    }

    @GetMapping
    public List<Stroke> getAllStrokes() {
        return strokeService.getAllStrokes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stroke> getStrokeById(@PathVariable Long id) {
        Optional<Stroke> stroke = strokeService.getStrokeById(id);
        return stroke.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stroke createStroke(@RequestBody Stroke stroke) {
        return strokeService.createStroke(stroke);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stroke> updateStroke(@PathVariable Long id, @RequestBody Stroke updatedStroke) {
        return strokeService.updateStroke(id, updatedStroke)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStroke(@PathVariable Long id) {
        if (strokeService.deleteStroke(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

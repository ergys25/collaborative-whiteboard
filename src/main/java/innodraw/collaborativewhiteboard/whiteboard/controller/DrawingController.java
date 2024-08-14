package innodraw.collaborativewhiteboard.whiteboard.controller;

import innodraw.collaborativewhiteboard.whiteboard.model.Drawing;
import innodraw.collaborativewhiteboard.whiteboard.service.DrawingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drawings")
public class DrawingController {

    private final DrawingService drawingService;

    public DrawingController(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @GetMapping
    public List<Drawing> getAllDrawings() {
        return drawingService.getAllDrawings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drawing> getDrawingById(@PathVariable Long id) {
        Optional<Drawing> drawing = drawingService.getDrawingById(id);
        return drawing.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Drawing createDrawing(@RequestBody Drawing drawing) {
        return drawingService.createDrawing(drawing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drawing> updateDrawing(@PathVariable Long id, @RequestBody Drawing updatedDrawing) {
        return drawingService.updateDrawing(id, updatedDrawing)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrawing(@PathVariable Long id) {
        if (drawingService.deleteDrawing(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

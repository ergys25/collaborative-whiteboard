package innodraw.collaborativewhiteboard.whiteboard.service;

import innodraw.collaborativewhiteboard.whiteboard.model.Drawing;
import innodraw.collaborativewhiteboard.whiteboard.repository.DrawingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrawingService {

    private final DrawingRepository drawingRepository;

    public DrawingService(DrawingRepository drawingRepository) {
        this.drawingRepository = drawingRepository;
    }

    public List<Drawing> getAllDrawings() {
        return drawingRepository.findAll();
    }

    public Optional<Drawing> getDrawingById(Long id) {
        return drawingRepository.findById(id);
    }

    public Drawing createDrawing(Drawing drawing) {
        return drawingRepository.save(drawing);
    }

    public Optional<Drawing> updateDrawing(Long id, Drawing updatedDrawing) {
        return drawingRepository.findById(id)
                .map(drawing -> {
                    drawing.setUser(updatedDrawing.getUser());
                    drawing.setStrokes(updatedDrawing.getStrokes());
                    return drawingRepository.save(drawing);
                });
    }

    public boolean deleteDrawing(Long id) {
        return drawingRepository.findById(id)
                .map(drawing -> {
                    drawingRepository.delete(drawing);
                    return true;
                })
                .orElse(false);
    }
}

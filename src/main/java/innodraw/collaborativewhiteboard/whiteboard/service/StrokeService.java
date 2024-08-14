package innodraw.collaborativewhiteboard.whiteboard.service;

import innodraw.collaborativewhiteboard.whiteboard.model.Stroke;
import innodraw.collaborativewhiteboard.whiteboard.repository.StrokeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrokeService {

    private final StrokeRepository strokeRepository;

    public StrokeService(StrokeRepository strokeRepository) {
        this.strokeRepository = strokeRepository;
    }

    public List<Stroke> getAllStrokes() {
        return strokeRepository.findAll();
    }

    public Optional<Stroke> getStrokeById(Long id) {
        return strokeRepository.findById(id);
    }

    public Stroke createStroke(Stroke stroke) {
        return strokeRepository.save(stroke);
    }

    public Optional<Stroke> updateStroke(Long id, Stroke updatedStroke) {
        return strokeRepository.findById(id)
                .map(stroke -> {
                    stroke.setColor(updatedStroke.getColor());
                    stroke.setThickness(updatedStroke.getThickness());
                    stroke.setPoints(updatedStroke.getPoints());
                    return strokeRepository.save(stroke);
                });
    }

    public boolean deleteStroke(Long id) {
        return strokeRepository.findById(id)
                .map(stroke -> {
                    strokeRepository.delete(stroke);
                    return true;
                })
                .orElse(false);
    }
}

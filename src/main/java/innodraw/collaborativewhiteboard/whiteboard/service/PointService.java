package innodraw.collaborativewhiteboard.whiteboard.service;

import innodraw.collaborativewhiteboard.whiteboard.model.Point;
import innodraw.collaborativewhiteboard.whiteboard.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    public Optional<Point> getPointById(Long id) {
        return pointRepository.findById(id);
    }

    public Point createPoint(Point point) {
        return pointRepository.save(point);
    }

    public Optional<Point> updatePoint(Long id, Point updatedPoint) {
        return pointRepository.findById(id)
                .map(point -> {
                    point.setX(updatedPoint.getX());
                    point.setY(updatedPoint.getY());
                    return pointRepository.save(point);
                });
    }

    public boolean deletePoint(Long id) {
        return pointRepository.findById(id)
                .map(point -> {
                    pointRepository.delete(point);
                    return true;
                })
                .orElse(false);
    }
}

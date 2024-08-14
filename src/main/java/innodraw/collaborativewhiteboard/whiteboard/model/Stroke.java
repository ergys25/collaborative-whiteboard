package innodraw.collaborativewhiteboard.whiteboard.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Stroke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drawing_id", nullable = false)
    private Drawing drawing;

    @OneToMany(mappedBy = "stroke", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Point> points;

    private String color;

    private int thickness;

    // Constructors, getters, setters, etc.

    public Stroke() {}

    public Stroke(Drawing drawing, String color, int thickness) {
        this.drawing = drawing;
        this.color = color;
        this.thickness = thickness;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}
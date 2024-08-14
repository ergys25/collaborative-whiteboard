package innodraw.collaborativewhiteboard.whiteboard.model;

import jakarta.persistence.*;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stroke_id", nullable = false)
    private Stroke stroke;

    private float x;

    private float y;

    // Constructors, getters, setters, etc.

    public Point() {}

    public Point(Stroke stroke, float x, float y) {
        this.stroke = stroke;
        this.x = x;
        this.y = y;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
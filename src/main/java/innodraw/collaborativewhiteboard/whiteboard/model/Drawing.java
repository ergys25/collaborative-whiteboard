package innodraw.collaborativewhiteboard.whiteboard.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Drawing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @OneToMany(mappedBy = "drawing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Stroke> strokes;

    // Constructors, getters, setters, etc.

    public Drawing() {}

    public Drawing(AppUser user) {
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Set<Stroke> getStrokes() {
        return strokes;
    }

    public void setStrokes(Set<Stroke> strokes) {
        this.strokes = strokes;
    }
}
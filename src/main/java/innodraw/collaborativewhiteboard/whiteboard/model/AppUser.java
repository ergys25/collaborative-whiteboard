package innodraw.collaborativewhiteboard.whiteboard.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Drawing> drawings;

    // Constructors, getters, setters, etc.

    public AppUser() {}

    public AppUser(String username) {
        this.username = username;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Drawing> getDrawings() {
        return drawings;
    }

    public void setDrawings(Set<Drawing> drawings) {
        this.drawings = drawings;
    }
}

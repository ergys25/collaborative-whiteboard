package innodraw.collaborativewhiteboard.whiteboard.service;

import innodraw.collaborativewhiteboard.whiteboard.model.AppUser;
import innodraw.collaborativewhiteboard.whiteboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

    public Optional<AppUser> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean userExists(Long id) {
        return userRepository.existsById(id);
    }
}

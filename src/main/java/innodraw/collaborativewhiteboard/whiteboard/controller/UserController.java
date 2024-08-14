package innodraw.collaborativewhiteboard.whiteboard.controller;

import innodraw.collaborativewhiteboard.whiteboard.model.AppUser;
import innodraw.collaborativewhiteboard.whiteboard.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        AppUser savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        Optional<AppUser> user = userService.findUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Long id, @RequestBody AppUser updatedUser) {
        Optional<AppUser> existingUser = userService.findUserById(id);
        if (existingUser.isPresent()) {
            AppUser user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            // You can add more fields to update if necessary
            AppUser savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<AppUser> user = userService.findUserById(id);
        if (user.isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

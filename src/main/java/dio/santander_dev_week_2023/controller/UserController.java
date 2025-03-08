package dio.santander_dev_week_2023.controller;

import dio.santander_dev_week_2023.domain.model.User;
import dio.santander_dev_week_2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.create(user);
        URI location = URI.create("/users/" + createdUser.getId());

        return ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.findAll());
    }
}

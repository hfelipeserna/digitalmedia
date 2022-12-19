package digitalmedia.msusers.controller;

import digitalmedia.msusers.models.User;
import digitalmedia.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserBillsById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.getBillsByUserId(id));
    }
}

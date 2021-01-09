package pl.edu.knbit.bitjava.resourceserver.api.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    public Principal getUser(Principal principal) {
        if (principal == null) {
            throw new RuntimeException("No auth token provided");
        }
        return principal;
    }

}

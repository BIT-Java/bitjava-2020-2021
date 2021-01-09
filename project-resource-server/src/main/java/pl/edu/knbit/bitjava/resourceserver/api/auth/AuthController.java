package pl.edu.knbit.bitjava.resourceserver.api.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    @GetMapping("/callback")
    public String getCode(@RequestParam(required = false) Optional<String> code) {
        return "code: " + code.orElse("not-present");
    }

}

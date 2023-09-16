package engine.controller;

import engine.domain.AppUser;
import engine.dto.RegisterDto;
import engine.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String register(@Valid @RequestBody RegisterDto request) {
        var user = new AppUser();
        user.setUsername(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (!appUserRepository.existsAppUserByUsername(user.getUsername())) {
            appUserRepository.save(user);
            return "New user successfully registered";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
    }
}


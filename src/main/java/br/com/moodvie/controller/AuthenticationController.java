package br.com.moodvie.controller;

import br.com.moodvie.dto.LoginDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @PostMapping()
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO){
        var token = new UsernamePasswordAuthenticationToken(loginDTO.username(),loginDTO.password());
        Authentication authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public String helloWorld(){
        return "Hello World!";
    }

}

package com.javawebcar.controler;

import com.javawebcar.config.JwtTokenProvider;
import com.javawebcar.model.LoginRequest;
import com.javawebcar.model.UserRegistrationRequest;
import com.javawebcar.service.JpaUserDetailsService;
import com.javawebcar.model.User;
import com.javawebcar.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(loginRequest.getUsername());

            return ResponseEntity.ok(jwt);

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Thông tin đăng nhập không hợp lệ");
        }
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest registrationRequest) {
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            return ResponseEntity.status(400).body("Tên đăng nhập đã tồn tại");
        }

        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setName(registrationRequest.getName());
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPhone(registrationRequest.getPhone());
        newUser.setRole("customer");
        userRepository.save(newUser);

        return ResponseEntity.status(201).body("Đăng ký thành công");
    }
}

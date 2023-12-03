package com.teste.fast.security.controller;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.fast.security.dto.AuthenticationDTO;
import com.teste.fast.security.dto.LoginResponseDTO;
import com.teste.fast.security.dto.RegisterDTO;
import com.teste.fast.security.model.Users;
import com.teste.fast.security.repository.UserRepository;
import com.teste.fast.security.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutheticationContoller {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO authDTO){
		var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.getLogin(), authDTO.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((Users) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO){
		if(Objects.nonNull(this.userRepository.findByLogin(registerDTO.getLogin()))) {
			return ResponseEntity.badRequest().build();
		}
		String encrypted = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
		Users newUser = new Users(registerDTO.getLogin(), encrypted, registerDTO.getRole());
		this.userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}
}

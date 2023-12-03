package com.teste.fast.security.dto;

import com.teste.fast.security.model.UserRole;

import lombok.Data;

@Data
public class RegisterDTO {

	private String login;
	private String password;
	private UserRole role;

	public RegisterDTO(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
}

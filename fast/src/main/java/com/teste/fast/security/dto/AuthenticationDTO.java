package com.teste.fast.security.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

	private String login;
	private String password;

	public AuthenticationDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}

}

package edu.miu.compro;

import java.util.Objects;

import org.apache.catalina.CredentialHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptCredentialHandler implements CredentialHandler {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public boolean matches(String inputCredentials, String storedCredentials) {
		if(Objects.isNull(inputCredentials)) {
			return false;
		}
		else {
			return encoder.encode(inputCredentials).equals(storedCredentials);
		}
	}

	public String mutate(String inputCredentials) {
		if(Objects.isNull(inputCredentials)) {
			return null;
		}
		else {
			return encoder.encode(inputCredentials);
		}
	}

}

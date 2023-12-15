package com.kata.series.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kata.series.model.Person;
import com.kata.series.model.Roles;
import com.kata.series.repository.PersonRepository;

@Component
public class SchoolUsernameAndPasswordProvider implements AuthenticationProvider {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();

		String pwd = authentication.getCredentials().toString();
		Person person = personRepo.findByEmail(email);
		Map<String, String> attributes = new HashMap<>();
		attributes.put("email", email);
		if (null != person && person.getPersonId() > 0 && encoder.matches(pwd, person.getPwd())) {
			UsernamePasswordAuthenticationToken securityObj = new UsernamePasswordAuthenticationToken(person.getName(), pwd, getGrantedAuthorities(person.getRoles()));
			securityObj.setDetails(attributes);
			return securityObj;
		} else {
			throw new BadCredentialsException("Wrong User name and Password");
		}
	}

	Collection<GrantedAuthority> getGrantedAuthorities(Roles role) {
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName() ));
		return roles;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

package com.kata.series.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SecurityConfigurations {

	@Bean
	SecurityFilterChain configureHttp(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
		
		http
		.csrf(t -> t
				.ignoringRequestMatchers(mvcMatcherBuilder.pattern("/saveMsg"))
				.ignoringRequestMatchers(mvcMatcherBuilder.pattern("/public/**"))
				)
		.authorizeHttpRequests(
					(req) -> req
							.requestMatchers
							(
									mvcMatcherBuilder.pattern("/updateProfile"),
									mvcMatcherBuilder.pattern("/displayProfile"),
									mvcMatcherBuilder.pattern("/public/**"),
									mvcMatcherBuilder.pattern("/closeMsg"),
									mvcMatcherBuilder.pattern("/error"),
									mvcMatcherBuilder.pattern("/home"), 
									mvcMatcherBuilder.pattern("/holidays/**"),
									mvcMatcherBuilder.pattern("/contact"), 
									mvcMatcherBuilder.pattern("/saveMsg"),
									mvcMatcherBuilder.pattern("/about"),
									mvcMatcherBuilder.pattern("/login"),
									mvcMatcherBuilder.pattern("/logout"),
									mvcMatcherBuilder.pattern("/displayMessages")
							).permitAll()
							.requestMatchers(mvcMatcherBuilder.pattern("/courses")).authenticated()
							.requestMatchers(mvcMatcherBuilder.pattern("/dashboard")).authenticated()
							.requestMatchers(mvcMatcherBuilder.pattern("/assets/**")).permitAll()
							//.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/")).permitAll()
		  ) .formLogin(t->  t
				  				.loginPage("/login")
				  				.defaultSuccessUrl("/dashboard")
				  				.failureUrl("/login?error=true").permitAll()
				  	  )
			.logout(t->   t
								.logoutSuccessUrl("/login?logout=true")
								.invalidateHttpSession(true).permitAll()
					  )
		    .httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails admin = User.builder().username("Ishan")
				.password("$2a$10$ooyMCne/ZjtSfNQSG78Nuu/xlnAWVctLxNSBfLE9Ps7zlM4ITe/FC").roles("ADMIN", "USER")
				.build();

		UserDetails user = User.builder().username("Krishanu")
				.password("$2a$10$iv4XBjPaOfQ.yVzecFgaPOn6HReof6sOiyn02drjGzaKGRZ4C8EdG").roles("USER").build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	PasswordEncoder newPassWordEncoder() {
		return new BCryptPasswordEncoder(BCryptVersion.$2A);
	}

	//@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
	}

	@Lazy
	@Bean
	Authentication authentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	

}

package com.shahzad.audit;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditorConfig {

	@Bean
	public CustomAuditorAware auditorProvider() {
		return new CustomAuditorAware();
	}
}

class CustomAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

//		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
//				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
//			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
//
//				return Optional
//						.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
//			} else {
//				Principal p = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//				return Optional.ofNullable(p.getName());
//			}
//		} else {
//			return Optional.of("HRIS");
//		}
		return Optional.of("HRIS");
	}
}

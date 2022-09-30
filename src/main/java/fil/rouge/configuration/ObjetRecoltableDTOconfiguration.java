package fil.rouge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import fil.rouge.dto.ObjetRecoltableDTO;

@Configuration
public class ObjetRecoltableDTOconfiguration {
    
    @Bean
	@SessionScope
	public ObjetRecoltableDTO getoRDto() {
		return new ObjetRecoltableDTO();
	}
}

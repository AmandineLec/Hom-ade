package fil.rouge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import fil.rouge.dto.TabObjetRecoltableDTO;

@Configuration
public class TabObjetRecoltableDTOConfiguration {
    
    @Bean
	@SessionScope
	public TabObjetRecoltableDTO getTabObjetRecoltableDTO() {
		return new TabObjetRecoltableDTO();
	}
}

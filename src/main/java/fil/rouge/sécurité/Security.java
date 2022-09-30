package fil.rouge.sécurité;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class Security {

    @Bean // Dit quel encodeur spring doit utiliser
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests((authz) -> 
            authz
                .antMatchers("/api/**")
                .authenticated())
        .authorizeHttpRequests((authz) ->
            authz
                .antMatchers("/inscription")
                .permitAll())
        .authorizeHttpRequests((authz) ->
                authz
                    .antMatchers("/login")
                    .permitAll())
        .formLogin() // Pour ne pas avoir la page d'authentification -> acces à toutes les pages de localhost
            .loginPage("/login")
            ;

        return http.build();
    } 

    @Autowired
    private UserDetailsService pDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider(){
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(pDetailsService);
        authProvider.setPasswordEncoder(getEncoder());

        return authProvider;
    }


    // Colonnes obligatoires classe USER pour spring security: mail, password, id, enabled (compte validé)

}

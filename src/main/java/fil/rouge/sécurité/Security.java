package fil.rouge.sécurité;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class Security implements WebMvcConfigurer {
    // On ajoute l'interface WebMvcConfigurer pour avoir la méthode addCorsMappings

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
                .permitAll())
                // .authenticated())
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
            .loginProcessingUrl("/login")
            .permitAll()
            ;
        // On oublie pas d'ajouter la configuration CORS à notre requête Http (sinon ca marche pas ;) )
        // On désactive la protection CSRF pour autoriser l'envoi de données depuis un autre site
        return http.cors().and().csrf().disable().build();
    } 

    // On configure notre mapping pour qu'il autorise les différentes methodes dont on a besoin (GET, POST, etc)
    // Et on autorise l'origine localhost:4200
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedOrigins("http://localhost:4200")
            .allowCredentials(true);
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

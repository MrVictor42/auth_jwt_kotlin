package io.github.mrvictor42.clientesudemy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

//configurações de recursos(api)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // O ROLE TEM QUE SER EM MAIUSCULO
        http
            .authorizeRequests()
//                .antMatchers("/api/clientes/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/usuarios").permitAll()
                .antMatchers(
                        "/api/clientes/**","/api/servico-prestados/**"
                ).authenticated()
                .anyRequest().denyAll();
    }
}

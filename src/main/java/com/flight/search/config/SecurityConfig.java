package com.flight.search.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    private final DataSource securityDataSource;

    @Autowired
    public SecurityConfig(DataSource securityDataSource) {
        this.securityDataSource = securityDataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource);

    }

/*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                *//*.defaultSuccessUrl("/success", true)*//*
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http.sessionManagement().invalidSessionUrl("/showMyLoginPage");
}*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/authenticated", true)
                .permitAll()
                .and()
                .logout().permitAll();
    }


    @Bean
    public DataSource securityDataSource() throws Exception{

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try{
            securityDataSource.setDriverClass("com.mysql.jdbc.Driver");
        }catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        securityDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/flights_search_engine?useSSL=false&amp;serverTimezone=UTC");
        securityDataSource.setUser("flightsearch");
        securityDataSource.setPassword("flightsearch");

        securityDataSource.setInitialPoolSize(5);
        securityDataSource.setMinPoolSize(5);
        securityDataSource.setMaxPoolSize(20);
        securityDataSource.setMaxIdleTime(3000);


        return securityDataSource;
    }


}
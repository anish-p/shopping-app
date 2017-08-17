package com.tw.shoppingapp;

import com.tw.shoppingapp.gateways.user.inmemory.InMemoryUserGateway;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCase;
import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@SpringBootApplication
public class ShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

    @Bean
    protected UserRegistrationUseCase userRegistrationUseCase() {
        UserRegistrationUseCase userRegistrationUseCase = new UserRegistrationUseCase();
        userRegistrationUseCase.setUserGateway(inMemoryGateway());
        return userRegistrationUseCase;
    }

    @Bean
    protected InMemoryUserGateway inMemoryGateway() {
        return new InMemoryUserGateway();
    }

    @Bean
    @Profile("default")
    protected ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        registrationBean.addInitParameter("webAllowOthers", "true");
        return registrationBean;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("default")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9292");
    }
}

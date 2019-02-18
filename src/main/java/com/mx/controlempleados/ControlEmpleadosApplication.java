package com.mx.controlempleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mx.controlempleados.entity" })
@EnableJpaRepositories(basePackages = {"com.mx.controlempleados.repository"})
public class ControlEmpleadosApplication {

    private static Class MAIN_CLASS = ControlEmpleadosApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(MAIN_CLASS,args);
    }
}
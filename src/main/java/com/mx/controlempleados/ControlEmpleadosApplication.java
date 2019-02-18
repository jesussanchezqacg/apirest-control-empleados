package com.mx.controlempleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlEmpleadosApplication {

    private static Class MAIN_CLASS = ControlEmpleadosApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(MAIN_CLASS,args);
    }
}
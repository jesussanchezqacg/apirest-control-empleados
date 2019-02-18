package com.mx.controlempleados.entity;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "empleado")
@Table(name = "empleado", schema = "dbcontrolempleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Formula("nombre||' '||apellido_paterno||' '||apellido_materno")
    private String nombreCompleto;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "sexo", nullable = false)
    private char sexo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Timestamp fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "fecha_perfil", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaPerfil;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "corre_electronico")
    private String correoElectronico;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "rfc")
    private String rfc;

    @Column(name = "curp")
    private String curp;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "reg_vigente", nullable = false, columnDefinition = "NUMERIC DEFAULT 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean regVigente;
}
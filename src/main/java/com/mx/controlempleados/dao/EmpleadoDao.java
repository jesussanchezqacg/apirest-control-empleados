package com.mx.controlempleados.dao;

import com.mx.controlempleados.entity.Empleado;

import java.util.List;

public interface EmpleadoDao {
    List<Empleado> listByNombreCompleto(String nombreCompleto);
    List<Empleado> listByRfc(String rfc);
    List<Empleado> listByCurp(String curp);
    List<Empleado> listAll();
    Empleado findByIdEmpleado(int idEmpleado);
    Empleado save(Empleado idEmpleado);
    Empleado update(Empleado idEmpleado);
    boolean delete(int idEmpleado);
}
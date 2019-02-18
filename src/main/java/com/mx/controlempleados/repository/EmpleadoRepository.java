package com.mx.controlempleados.repository;

import com.mx.controlempleados.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {

    List<Empleado> findByNombreCompletoContainingIgnoreCaseAndRegVigenteIsTrueOrderByNombreCompletoAsc(String nombreCompleto);
    List<Empleado> findByRfcContainingIgnoreCaseAndRegVigenteIsTrueOrderByRfcAsc(String rfc);
    List<Empleado> findByCurpContainingIgnoreCaseAndRegVigenteIs1OrderByCurpAsc(String curp);
    Empleado findByIdEmpleadoAndRegVigenteIsTrue(int idEmpleado);
}
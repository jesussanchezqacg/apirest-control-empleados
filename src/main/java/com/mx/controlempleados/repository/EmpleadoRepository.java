package com.mx.controlempleados.repository;

import com.mx.controlempleados.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {

    List<Empleado> findByNombreCompletoContainingIgnoreCaseAAndRegVigenteIsTrueOrderByNombreCompletoAsc(String nombreCompleto);
    List<Empleado> findByRfcContainingIgnoreCaseOrderByRfcAsc(String rfc);
    List<Empleado> findByCurpContainingIgnoreCaseOrderByCurpAsc(String curp);
    Empleado findByIdEmpleado(int idEmpleado);
}
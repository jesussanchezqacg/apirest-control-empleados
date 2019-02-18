package com.mx.controlempleados.dao.impl;

import com.mx.controlempleados.dao.EmpleadoDao;
import com.mx.controlempleados.entity.Empleado;
import com.mx.controlempleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("empleadoDao")
public class EmpleadoDaoImpl implements EmpleadoDao {

    @Autowired
    @Qualifier("empleadoRepository")
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listByNombreCompleto(String nombreCompleto) {
        return empleadoRepository.findByNombreCompletoContainingIgnoreCaseAndRegVigenteIsTrueOrderByNombreCompletoAsc(nombreCompleto);
    }

    @Override
    public List<Empleado> listByRfc(String rfc) {
        return empleadoRepository.findByRfcContainingIgnoreCaseOrderByRfcAsc(rfc);
    }

    @Override
    public List<Empleado> listByCurp(String curp) {
        return empleadoRepository.findByCurpContainingIgnoreCaseOrderByCurpAsc(curp);
    }

    @Override
    public List<Empleado> listAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findByIdEmpleado(int idEmpleado) {
        return empleadoRepository.findByIdEmpleado(idEmpleado);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public boolean delete(int idEmpleado) {
        return empleadoRepository.findById(new Integer(idEmpleado)).map(item -> {
            item.setRegVigente(false);
            empleadoRepository.save(item);
            return true;
        }).orElse(false);
    }
}

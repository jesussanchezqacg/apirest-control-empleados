package com.mx.controlempleados.service;

import com.mx.controlempleados.dao.EmpleadoDao;
import com.mx.controlempleados.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service("empleadoService")
public class EmpleadoService {

    @Autowired
    @Qualifier("empleadoDao")
    private EmpleadoDao empleadoDao;

    public List<Empleado> listByNombreCompleto(String nombreCompleto) {
        return empleadoDao.listByNombreCompleto(nombreCompleto);
    }

    public List<Empleado> listByRfc(String rfc) {
        return empleadoDao.listByRfc(rfc);
    }

    public List<Empleado> listByCurp(String curp) {
        return empleadoDao.listByCurp(curp);
    }

    public List<Empleado> listAll() {
        return empleadoDao.listAll();
    }

    public Empleado findByIdEmpleado(int idEmpleado) {
        return empleadoDao.findByIdEmpleado(idEmpleado);
    }

    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    @Transactional
    public Empleado update(Empleado empleado) {
        return empleadoDao.update(empleado);
    }

    @Transactional
    public boolean delete(int idEmpleado) {
        return empleadoDao.delete(idEmpleado);
    }
}

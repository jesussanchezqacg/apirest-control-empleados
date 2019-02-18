package com.mx.controlempleados.rest;

import com.mx.controlempleados.CustomNotFoundException;
import com.mx.controlempleados.entity.Empleado;
import com.mx.controlempleados.service.EmpleadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("apiEmpleado")
@RequestMapping("/api/empleado/")
@Api(value = "/api/empleado/",
     description = "API RESTFul (Representational State Transfer) :: Empleado",
     produces = "application/json,application/json;charset=UTF-8",
     consumes = "application/json,application/json;charset=UTF-8")
public class EmpleadoRest {

    @Autowired
    @Qualifier("empleadoService")
    private EmpleadoService empleadoService;

    @GetMapping(name = "findAllByNombreCompleto",
                path = "findAllByNombreCompleto",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.ALL_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de empleados por nombre completo", response = List.class)
    private ResponseEntity<List<Empleado>> findAllByNombreCompleto(@RequestBody Empleado empleado) throws CustomNotFoundException {
        List<Empleado> listEmpleado;
        if(empleado == null || !(empleado instanceof Empleado)) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else if (empleado.getNombreCompleto().isEmpty() || empleado.getNombreCompleto() == null) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else {
            listEmpleado = empleadoService.listByNombreCompleto(empleado.getNombreCompleto());
        }
        return ResponseEntity.ok(listEmpleado);
    }


    @GetMapping(name = "findAllByRfc",
                path = "findAllByRfc",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de empleados por rfc", response = List.class)
    private ResponseEntity<List<Empleado>> findAllByRfc(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.listByRfc(empleado.getRfc()));
    }

    @GetMapping(name = "findAllByCurp",
                path = "findAllByCurp",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de empleados por curp", response = List.class)
    private ResponseEntity<List<Empleado>> findAllByCurp(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.listByCurp(empleado.getCurp()));
    }

    @GetMapping(name = "findAll",
                path = "findAll",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de empleados", response = List.class)
    private ResponseEntity<List<Empleado>> findAll() {
        return ResponseEntity.ok(empleadoService.listAll());
    }

    @GetMapping(name = "findByIdEmpleado",
                path = "findByIdEmpleado",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de empleados por id", response = Empleado.class)
    private ResponseEntity<Empleado> findByIdEmpleado(@RequestBody Empleado empleado) {
        if(empleado == null || !(empleado instanceof Empleado)) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else if (empleado.getIdEmpleado() == 0) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(empleadoService.findByIdEmpleado(empleado.getIdEmpleado()));
        }
    }

    @PostMapping(name = "saveEmpleado",
                 path = "saveEmpleado",
                 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                 consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Guardar Empleado", response = Empleado.class)
    private ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        if(empleado == null || !(empleado instanceof Empleado)) {
            throw new RuntimeException("El parametro empleado no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(empleadoService.save(empleado));
        }
    }

    @PutMapping(name = "updateEmpleado",
                path = "updateEmpleado",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Actualizar Empleado", response = Empleado.class)
    private ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado) {
        if(empleado == null || !(empleado instanceof Empleado)) {
            throw new RuntimeException("El parametro empleado no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(empleadoService.save(empleado));
        }
    }

    @DeleteMapping(name = "deleteEmpleado",
                   path = "deleteEmpleado",
                   produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                   consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Eliminar Empleado", response = Map.class)
    private ResponseEntity<Map<String,Object>> deleteEmpleado(@RequestBody Empleado empleado) {
        if(empleado == null || !(empleado instanceof Empleado)) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else if (empleado.getIdEmpleado() == 0) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else {
            Map<String,Object> map = new HashMap<>();
            map.put("eliminado",empleadoService.delete(empleado.getIdEmpleado()));
            return ResponseEntity.ok(map);
        }
    }
}
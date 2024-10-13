package gm.rh.controlador;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh-app")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados() {
        var empleados = empleadoServicio.findAll();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return (List<Empleado>) empleados;
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Integer id) {
        return empleadoServicio.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/empleados/save")
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
        try{
            return new ResponseEntity<>(empleadoServicio.save(empleado), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/empleados/estado/{id}/{estado}")
    public String cambiarEstadoEmpleado(@PathVariable Integer id, @PathVariable boolean estado) {
        empleadoServicio.actualizarEstado(id, estado);
        return estado ? "Empleado activado con éxito." : "Empleado desactivado con éxito.";
    }
}

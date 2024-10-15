package gm.rh.controlador;

import gm.rh.modelo.Departamento;
import gm.rh.modelo.Empleado;
import gm.rh.servicio.DepartamentoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh-app")
@CrossOrigin(origins = "*")
public class DepartamentoControlador {
    private static final Logger logger = LoggerFactory.getLogger(DepartamentoControlador.class);

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping("/departamentos")
    public List<Departamento> obtenerDepartamentos() {
        var departamentos = departamentoServicio.findAll();
        departamentos.forEach((departamento -> logger.info(departamento.toString())));
        return (List<Departamento>) departamentos;
    }

    @PostMapping("/departamentos/save")
    public ResponseEntity<Departamento> save(@RequestBody Departamento departamento) {
        try{
            return new ResponseEntity<>(departamentoServicio.save(departamento), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/departamentos/{id}")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable Integer id) {
        return departamentoServicio.findById(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/departamentos/estado/{id}/{estado}")
    public String cambiarEstadoDepartamento(@PathVariable Integer id, @PathVariable boolean estado) {
        departamentoServicio.actualizarEstado(id, estado);
        return estado ? "Departamento activado con éxito." : "Departamento desactivado con éxito.";
    }
}

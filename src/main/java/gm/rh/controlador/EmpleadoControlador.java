package gm.rh.controlador;

import gm.rh.servicio.EmpleadoServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rh-app")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;
}

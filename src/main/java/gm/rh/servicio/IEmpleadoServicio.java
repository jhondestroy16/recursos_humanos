package gm.rh.servicio;

import gm.rh.dto.EmpleadoDTO;
import gm.rh.modelo.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmpleadoServicio extends CrudRepository<Empleado, Integer> {
    void actualizarEstado(Integer id, Boolean estado);

    List<EmpleadoDTO> obtenerEmpleadosConDepartamentos();
}

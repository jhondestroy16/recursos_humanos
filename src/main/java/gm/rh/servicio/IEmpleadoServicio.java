package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpleadoServicio extends CrudRepository<Empleado, Integer> {
    public List<Empleado> ListarEmpleados();

    public Empleado BuscarEmpleadoPorId(int id);
}

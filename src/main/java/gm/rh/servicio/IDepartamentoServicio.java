package gm.rh.servicio;

import gm.rh.modelo.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoServicio extends CrudRepository<Departamento, Integer> {
    void actualizarEstado(Integer id, Boolean estado);
}

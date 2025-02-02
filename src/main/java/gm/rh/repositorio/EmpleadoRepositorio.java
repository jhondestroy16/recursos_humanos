package gm.rh.repositorio;

import gm.rh.dto.EmpleadoDTO;
import gm.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Empleado e SET e.estado = :estado WHERE e.id = :id")
    void actualizarEstado(@Param("id") Integer id, @Param("estado") Boolean estado);

    @Query("SELECT new gm.rh.dto.EmpleadoDTO(e.id, e.nombre, e.salario, e.estado, d.nombre) " +
            "FROM Empleado e JOIN e.departamento d")
    List<EmpleadoDTO> findAllEmpleadosConDepartamentos();

}

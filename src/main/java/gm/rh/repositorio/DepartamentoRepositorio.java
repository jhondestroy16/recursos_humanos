package gm.rh.repositorio;

import gm.rh.modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Empleado e SET e.estado = :estado WHERE e.id = :id")
    void actualizarEstado(@Param("id") Integer id, @Param("estado") Boolean estado);
}

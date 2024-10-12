package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import gm.rh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class EmpleadoServicio implements IEmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio repositorio;
    @Override
    public List<Empleado> ListarEmpleados() {
        return repositorio.findAll();
    }

    @Override
    public Empleado BuscarEmpleadoPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public <S extends Empleado> S save(S entity) {
        return repositorio.save(entity);
    }

    @Override
    public <S extends Empleado> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Empleado> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Empleado> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Iterable<Empleado> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return repositorio.count();
    }

    @Override
    public void deleteById(Integer integer) {
        repositorio.deleteAllById(Collections.singleton(integer));
    }

    @Override
    public void delete(Empleado entity) {
        repositorio.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        repositorio.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Empleado> entities) {
        repositorio.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repositorio.deleteAll();
    }
}

package gm.rh.servicio;

import gm.rh.modelo.Departamento;
import gm.rh.repositorio.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
public class DepartamentoServicio implements IDepartamentoServicio{
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;
    @Override
    public void actualizarEstado(Integer id, Boolean estado) {
        Optional<Departamento> departamento = departamentoRepositorio.findById(id);
        if (departamento.isPresent()) {
            departamentoRepositorio.actualizarEstado(id, estado);
        } else {
            throw new RuntimeException("Departamento no encontrado con ID: " + id);
        }
    }

    @Override
    public <S extends Departamento> S save(S entity) {
        return departamentoRepositorio.save(entity);
    }

    @Override
    public <S extends Departamento> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Departamento> findById(Integer integer) {
        return departamentoRepositorio.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return departamentoRepositorio.existsById(integer);
    }

    @Override
    public Iterable<Departamento> findAll() {
        return departamentoRepositorio.findAll();
    }

    @Override
    public Iterable<Departamento> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return departamentoRepositorio.count();
    }

    @Override
    public void deleteById(Integer integer) {
        departamentoRepositorio.deleteAllById(Collections.singleton(integer));
    }

    @Override
    public void delete(Departamento entity) {
        departamentoRepositorio.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        departamentoRepositorio.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Departamento> entities) {
        departamentoRepositorio.deleteAll();
    }

    @Override
    public void deleteAll() {
        departamentoRepositorio.deleteAll();
    }
}

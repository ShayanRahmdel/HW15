package base.service.impl;

import base.entity.CourseBaseEntity;
import base.repository.CourseBaseEntityRepository;
import base.service.CourseBaseEntiyService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public class CourseBaseEntityServiceImpl <T extends CourseBaseEntity<ID>,ID extends Serializable,
        R extends CourseBaseEntityRepository<T,ID>> implements CourseBaseEntiyService<T,ID> {

    protected final R repository;


    @Override
    public T saveOrUpdate(T entity) {
        return repository.saveOrUpdate(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void beginTransaction() {
        repository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        repository.commitTransaction();
    }

    @Override
    public void rollback() {
        repository.rollBack();
    }


}

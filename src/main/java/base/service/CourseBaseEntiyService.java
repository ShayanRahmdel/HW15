package base.service;

import base.entity.CourseBaseEntity;
import base.entity.PersonBaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface CourseBaseEntiyService <T extends CourseBaseEntity<ID>,ID extends Serializable>{
    T saveOrUpdate(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    Collection<T> findAll();

    void beginTransaction();

    void commitTransaction();

    void rollback();

}

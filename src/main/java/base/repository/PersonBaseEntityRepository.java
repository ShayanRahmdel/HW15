package base.repository;

import base.entity.PersonBaseEntity;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PersonBaseEntityRepository <T extends PersonBaseEntity<ID>, ID extends Serializable>{

        T saveOrUpdate(T entity);

        Optional<T> findById(ID id);

        void deleteById(ID id);

        Collection<T> findAll();

        void beginTransaction();

        void commitTransaction();

        void rollBack();


}

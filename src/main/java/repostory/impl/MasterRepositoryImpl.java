package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.*;
import repostory.MasterRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class MasterRepositoryImpl extends BaseEntityRepositoryImpl<Master,Integer> implements MasterRepository {
    public MasterRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Class<Master> getEntityClass() {
        return Master.class;
    }

    @Override
    public Master findByUserNameAndPassword(String userName, String password) {
        String hql = "Select s FROM Master s WHERE s.userName= :userName and s.password= :password";
        TypedQuery<Master> query = entityManager.createQuery(hql, Master.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public Long findUnitInTerm(Integer masterId, Term term) {
        String jpql = "SELECT SUM(c.lesson.unit) FROM Course c WHERE c.master.id = :masterId AND c.term.year = :year AND c.term.midTerm = :midTerm";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter("masterId", masterId);
        query.setParameter("year", term.getYear());
        query.setParameter("midTerm", term.getMidTerm());
        Long sumUnit = query.getSingleResult();
        return sumUnit;
    }
}

package repostory.impl;

import base.repository.impl.PersonBaseEntityRepositoryImpl;
import entity.Master;
import repostory.MasterRepository;

import javax.persistence.EntityManager;

public class MasterRepositoryImpl extends PersonBaseEntityRepositoryImpl<Master,Integer> implements MasterRepository {
    public MasterRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Master> getEntityClass() {
        return Master.class;
    }
}

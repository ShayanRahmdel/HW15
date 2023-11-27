package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Master;
import repostory.MasterRepository;

import javax.persistence.EntityManager;

public class MasterRepositoryImpl extends BaseEntityRepositoryImpl<Master,Integer> implements MasterRepository {
    public MasterRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Master> getEntityClass() {
        return Master.class;
    }
}

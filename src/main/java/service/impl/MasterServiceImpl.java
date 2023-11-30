package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Master;
import entity.Term;
import repostory.MasterRepository;
import service.MasterService;

public class MasterServiceImpl extends BaseEntityServiceImpl<Master,Integer, MasterRepository> implements MasterService {
    public MasterServiceImpl(MasterRepository repository) {
        super(repository);
    }

    @Override
    public Master findByUserNameAndPassword(String userName, String password) {
        return repository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public Long findUnitInTerm(Integer masterId, Term term) {
        return repository.findUnitInTerm(masterId,term);
    }


}

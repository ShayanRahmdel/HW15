package service.impl;

import base.service.impl.PersonBaseEntityServiceImpl;
import entity.Master;
import repostory.MasterRepository;
import service.MasterService;

public class MasterServiceImpl extends PersonBaseEntityServiceImpl<Master,Integer, MasterRepository> implements MasterService {
    public MasterServiceImpl(MasterRepository repository) {
        super(repository);
    }
}

package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Master;
import repostory.MasterRepository;
import service.MasterService;

public class MasterServiceImpl extends BaseEntityServiceImpl<Master,Integer, MasterRepository> implements MasterService {
    public MasterServiceImpl(MasterRepository repository) {
        super(repository);
    }
}

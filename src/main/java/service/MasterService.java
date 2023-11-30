package service;

import base.service.BaseService;
import entity.Master;
import entity.Term;

public interface MasterService extends BaseService<Master,Integer> {
    Master findByUserNameAndPassword(String userName, String password);

    Long findUnitInTerm(Integer masterId, Term term);
}

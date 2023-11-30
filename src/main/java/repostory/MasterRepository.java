package repostory;

import base.repository.BaseEntityRepository;
import entity.Master;
import entity.Student;
import entity.Term;

public interface MasterRepository extends BaseEntityRepository<Master,Integer> {

    Master findByUserNameAndPassword(String userName, String password);

    Long findUnitInTerm(Integer masterId, Term term);
}

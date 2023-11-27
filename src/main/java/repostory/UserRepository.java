package repostory;

import base.repository.BaseEntityRepository;
import entity.User;

public interface UserRepository extends BaseEntityRepository<User,Integer> {

    User findByUsernameAndPassword(String userName,String password);
}

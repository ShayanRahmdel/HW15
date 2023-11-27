package service;

import base.service.BaseService;
import entity.User;

public interface UserService extends BaseService<User,Integer> {

    User findByUsernameAndPassword(String userName,String password);
}

package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.User;
import repostory.UserRepository;
import service.UserService;

public class UserServiceImpl extends BaseEntityServiceImpl<User,Integer, UserRepository>implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsernameAndPassword(String userName,String password) {
        return repository.findByUsernameAndPassword(userName,password);
    }
}

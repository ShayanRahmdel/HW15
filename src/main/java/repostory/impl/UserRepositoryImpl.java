package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.User;
import repostory.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User,Integer> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsernameAndPassword(String userName, String password) {
        String hql = "select u from User_table u where u.userName= :userName and u.password= :password";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getSingleResult();
    }
}

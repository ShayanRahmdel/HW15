package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Employee;
import entity.Student;
import repostory.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentRepostoryImpl extends BaseEntityRepositoryImpl<Student,Integer> implements StudentRepository {

    public StudentRepostoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }


    @Override
    public Student findByUserNameAndPasswordReturn(String userName, String password) {
        String hql = "Select s FROM Student s WHERE s.userName= :userName and s.password= :password";
        TypedQuery<Student> query = entityManager.createQuery(hql, Student.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getSingleResult();
    }

    @Override
    public Boolean findByUserNameAndPassword(String userName, String password) {
        String hql = "Select s FROM Student s WHERE s.userName= :userName and s.password= :password";
        TypedQuery<Student> query = entityManager.createQuery(hql, Student.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getSingleResult() != null;
    }
}

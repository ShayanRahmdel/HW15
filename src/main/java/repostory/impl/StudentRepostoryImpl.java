package repostory.impl;

import base.repository.impl.PersonBaseEntityRepositoryImpl;
import entity.Student;
import repostory.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepostoryImpl extends PersonBaseEntityRepositoryImpl<Student,Integer> implements StudentRepository {

    public StudentRepostoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }


}

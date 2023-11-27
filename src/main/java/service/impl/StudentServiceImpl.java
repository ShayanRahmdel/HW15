package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Employee;
import entity.Student;
import repostory.StudentRepository;
import service.StudentService;

public class StudentServiceImpl extends BaseEntityServiceImpl<Student,Integer, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }


    @Override
    public Student findByUserNameAndPasswordReturn(String userName, String password) {
        return repository.findByUserNameAndPasswordReturn(userName,password);
    }

    @Override
    public Boolean findByUserNameAndPassword(String userName, String password) {
        return repository.findByUserNameAndPassword(userName,password);
    }
}

package service.impl;

import base.service.PersonBaseService;
import base.service.impl.PersonBaseEntityServiceImpl;
import entity.Student;
import repostory.StudentRepository;
import service.StudentService;

public class StudentServiceImpl extends PersonBaseEntityServiceImpl<Student,Integer, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }


}

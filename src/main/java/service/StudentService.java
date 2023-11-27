package service;

import base.service.BaseService;
import entity.Employee;
import entity.Student;

public interface StudentService extends BaseService<Student,Integer> {

    Student findByUserNameAndPasswordReturn(String userName, String password);
    Boolean findByUserNameAndPassword(String userName, String password);
}

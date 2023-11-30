package service;

import base.service.BaseService;
import entity.Course;
import entity.Employee;
import entity.Student;

public interface StudentService extends BaseService<Student,Integer> {

    Student findByUserNameAndPasswordReturn(String userName, String password);
    Boolean findByUserNameAndPassword(String userName, String password);

    boolean chooseCourses(Student student, Course availableCourses);



}

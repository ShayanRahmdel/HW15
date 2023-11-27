package repostory;

import base.repository.BaseEntityRepository;
import entity.Employee;
import entity.Student;

public interface StudentRepository extends BaseEntityRepository<Student,Integer> {

    Student findByUserNameAndPasswordReturn(String userName, String password);
    Boolean findByUserNameAndPassword(String userName, String password);
}

package repostory;

import base.repository.BaseEntityRepository;
import entity.Employee;

import java.util.Date;

public interface EmployeeRepository extends BaseEntityRepository<Employee,Integer> {

     Boolean findByUserNameAndPassword(String userName,String password);
     Employee findByUserNameAndPasswordReturn(String userName,String password);

     Double showSalary(Integer id);

}

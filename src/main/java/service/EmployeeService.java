package service;

import base.service.BaseService;
import entity.Employee;

public interface EmployeeService extends BaseService<Employee,Integer> {
    Boolean findByUserNameAndPassword(String userName,String password);
    Employee findByUserNameAndPasswordReturn(String userName,String password);
    Double showSalary(Integer id);

}
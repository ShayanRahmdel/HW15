package service.impl;

import base.service.impl.PersonBaseEntityServiceImpl;
import entity.Employee;
import repostory.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl extends PersonBaseEntityServiceImpl<Employee,Integer, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}

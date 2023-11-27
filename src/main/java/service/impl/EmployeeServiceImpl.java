package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Employee;
import repostory.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee,Integer, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Boolean findByUserNameAndPassword(String userName, String password) {
        return repository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public Employee findByUserNameAndPasswordReturn(String userName, String password) {
        return repository.findByUserNameAndPasswordReturn(userName,password);
    }

    @Override
    public Double showSalary(Integer id) {
        repository.findById(id);
        System.out.println();
        return  repository.showSalary(id);
    }


}

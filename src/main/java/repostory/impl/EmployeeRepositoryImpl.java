package repostory.impl;

import base.repository.impl.PersonBaseEntityRepositoryImpl;
import entity.Employee;
import repostory.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl extends PersonBaseEntityRepositoryImpl<Employee,Integer>
        implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}

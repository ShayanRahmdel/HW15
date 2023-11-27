package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Employee;
import repostory.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmployeeRepositoryImpl extends BaseEntityRepositoryImpl<Employee,Integer>
        implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public Boolean findByUserNameAndPassword(String userName,String password) {
        String hql = "Select e FROM Employee e WHERE e.userName= :userName and e.password= :password";
        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getSingleResult() != null;

    }

    @Override
    public Employee findByUserNameAndPasswordReturn(String userName, String password) {
        String hql = "Select e FROM Employee e WHERE e.userName= :userName and e.password= :password";
        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getSingleResult();
    }

    @Override
    public Double showSalary(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root.get("salary"));
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();

    }


}

package entity;

import base.entity.PersonBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends PersonBaseEntity<Long> {
    @Column(unique = true,length = 6,nullable = false)
    private String employeeNumber;

    private Double salary = 10000.0;
}

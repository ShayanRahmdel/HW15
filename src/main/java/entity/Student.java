package entity;

import base.entity.PersonBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends PersonBaseEntity<Long> {
        @Column(unique = true,length = 6,nullable = false)
        private String studentNumber;


}

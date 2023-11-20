package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends User  {
    @Column(unique = true,length = 6,nullable = false)
    private String employeeNumber;

    private Double salary = 700000.0;
}

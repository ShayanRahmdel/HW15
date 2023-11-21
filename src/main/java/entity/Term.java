package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Term extends PersonBaseEntity<Integer> {


    @Max(value = 24,message = "Your units greater than 24")
    @Min(value = 20,message = "Your unit Less than 20")
    private int totalUnit;

    @Max(value = 20,message = "GPA cant greater than 20")
    @Min(value = 5,message = "GPA cant less than 5")
    private Double gpa;

    @ManyToOne
    private Master master;
    @ManyToOne
    private Student student;


}

package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends User {
        @Column(unique = true,length = 6,nullable = false)
        private String studentNumber;


        @Column(nullable = false)
        @Max(value = 20,message = "Your GPA Greater than 20")
        @Min(value = 12,message = "Your GPA less than 12")
        private Double lastGPA;


        @ManyToMany
        private List<ChosenCourse> chosenCourses;





}

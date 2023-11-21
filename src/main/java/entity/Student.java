package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends User {
    @Column(unique = true, length = 6, nullable = false)
    private String studentNumber;






    @ManyToMany
    private List<ChosenCourse> chosenCourses;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<ChosenCourse> chosenCourse;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Term> terms;


    public Student(@NotNull String firstName, @NotNull String lastName, String userName, String password, Date dob,
                   @Email String email, @Max(value = 80, message = "Your age greater than our rules")
                   @Min(value = 15, message = "Your age less than our rules") Integer age, String city, Character gender, String studentNumber) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.studentNumber = studentNumber;

    }

    public Student(Integer id, @NotNull String firstName, @NotNull String lastName, String userName, String password
            , Date dob, @Email String email, @Max(value = 80, message = "Your age greater than our rules")
                   @Min(value = 15, message = "Your age less than our rules") Integer age, String city, Character gender, String studentNumber
            ) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.setId(id);
        this.studentNumber = studentNumber;

    }

}


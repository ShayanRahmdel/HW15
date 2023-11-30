package entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student extends User {

    @Column(unique = true, length = 6, nullable = false)
    private String studentNumber;



    @OneToMany(mappedBy = "student")
    private Set<ReportCard> reportCards;



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

    public Student(Integer id) {
        this.setId(id);
    }

    @Override
    public String toString() {
        return "Student { " +
                "FirstName: "+ getFirstName() +
                " LastName: "+ getLastName() +
                " studentNumber= '" + studentNumber + '\'' +
                '}';
    }
}


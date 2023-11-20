package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@Entity(name = "User_table")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends PersonBaseEntity<Integer> {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Column(nullable = false,length = 10,unique = true)
    private String userName;
    @Column(nullable = false,length = 8)
    private String password;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Email
    private String email;
    @Max(value = 80,message = "Your age greater than our rules")
    @Min(value = 15,message = "Your age less than our rules")
    private Integer age;
    @Column(nullable = false,length = 20)
    private String city;

    @Column(nullable = false)
    private Character gender;
}

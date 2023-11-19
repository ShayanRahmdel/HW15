package base.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@MappedSuperclass
public class PersonBaseEntity<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
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

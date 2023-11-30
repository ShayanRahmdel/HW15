package entity;

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

public class Master extends User {
    @Column(unique = true,length = 6,nullable = false)
    private String masterNumber;
    @Enumerated(EnumType.STRING)
    private MasterType masterType;

    private Double salary= 1000000.0;




    public Master(@NotNull String firstName, @NotNull String lastName, String userName, String password, Date dob, @Email String email, @Max(value = 80, message = "Your age greater than our rules") @Min(value = 15, message = "Your age less than our rules") Integer age, String city, Character gender, String masterNumber, MasterType masterType) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.masterNumber = masterNumber;
        this.masterType = masterType;

    }
    public Master(Integer id,@NotNull String firstName, @NotNull String lastName, String userName, String password, Date dob, @Email String email, @Max(value = 80, message = "Your age greater than our rules") @Min(value = 15, message = "Your age less than our rules") Integer age, String city, Character gender, String masterNumber, MasterType masterType) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.setId(id);
        this.masterNumber = masterNumber;
        this.masterType = masterType;

    }

    public Master(Integer id) {
        this.setId(id);
    }

    @Override
    public String toString() {
        return "Master Detail: " +"\n"+
                "Master number: "+ getMasterNumber()+"\n"+
                "FirstName: "+getFirstName()+"\n"+
                "LastName: "+getLastName()+"\n"+
                "Age:  "+getAge()+"\n"+
                "masterNumber:  " + masterNumber + "\n" +
                "masterType:  " + masterType + "\n"+
                "==========================="+"\n";
    }
}

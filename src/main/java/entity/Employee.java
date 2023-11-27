package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User  {
    @Column(unique = true,length = 6,nullable = false)
    private String employeeNumber;

    private Double salary = 700000.0;

    public Employee(@NotNull String firstName, @NotNull String lastName, String userName, String password, Date dob, @Email String email,
                    @Max(value = 80, message = "Your age greater than our rules") @Min(value = 15,
            message = "Your age less than our rules") Integer age, String city, Character gender, String employeeNumber) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.employeeNumber = employeeNumber;
    }
    public Employee(Integer id,@NotNull String firstName, @NotNull String lastName, String userName, String password, Date dob, @Email String email,
                    @Max(value = 80, message = "Your age greater than our rules") @Min(value = 15,
                            message = "Your age less than our rules") Integer age, String city, Character gender, String employeeNumber) {
        super(firstName, lastName, userName, password, dob, email, age, city, gender);
        this.setId(id);
        this.employeeNumber = employeeNumber;
    }
    public Employee(String userName,String password){
        this.setUserName(userName);
        this.setPassword(password);
    }

    @Override
    public String toString() {
        return " Employee {"+
                "Name: "+ getFirstName() +
                " lastName: "+ getLastName() +
                " employeeNumber= '" + employeeNumber + '\'' +
                ", salary= " + salary +
                '}';
    }
}

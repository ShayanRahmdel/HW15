package base.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@MappedSuperclass
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseBaseEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
    @Column(unique = true,nullable = false,length = 10)
    private String name;

    @Min(value = 1,message = "We dont have less than 1 unit")
    @Max(value = 3,message = "We dont have greater than 3 unit")
    private Integer unit;


}

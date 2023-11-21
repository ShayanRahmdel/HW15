package entity;

import base.entity.CourseBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course extends CourseBaseEntity<Integer> {
    @Temporal(value = TemporalType.DATE)
    private Date courseRelease;
    @Column(length = 30)
    private String explainCourse;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<ChosenCourse> ChosenCourse;


    public Course( String name, @Min(value = 1, message = "We dont have less than 1 unit") @Max(value = 3, message = "We dont have greater than 3 unit") Integer unit, Date courseRelease, String explainCourse) {
        super( name, unit);
        this.courseRelease = courseRelease;
        this.explainCourse = explainCourse;
    }
}

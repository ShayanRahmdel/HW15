package entity;

import base.entity.CourseBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChosenCourse extends CourseBaseEntity<Integer> {

    @Max(value = 20,message = "Your score greater than limit")
    @Min(value = 0,message = "Your sore less than limit")
    private Double score;


    @ManyToOne
    private Master master;


    private Boolean isPassed;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;

    public ChosenCourse(String name, Integer unit, Double score, Master master, Boolean isPassed) {
        super(name, unit);
        this.score = score;
        this.master = master;
        this.isPassed = isPassed;
    }
}

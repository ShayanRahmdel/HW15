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
}

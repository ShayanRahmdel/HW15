package entity;

import base.entity.CourseBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
}

package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
@Setter
@Getter
@Table(name = "report_card")
@Entity
public class ReportCard extends BaseEntity<Integer> {

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;


    @Max(value = 20,message = "Your mark greater Than 20")
    @Min(value = 0,message = "Your mark less than 0")
    private Double mark;


    public ReportCard(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public boolean isPass() {
        if (mark==null){
            return false;
        }
         else return mark > 10;
    }

    @Override
    public String toString() {
        return "ReportCard" +"\n"+
                "courseID: "+ course.getId()+"\n"+
                "course:" + course.getLesson().getTitle() +"\n"+
                "mark:" + mark +"\n"+
                "=============================================";
    }
}
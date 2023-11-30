package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
@Entity
public class Course extends BaseEntity<Integer> {

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Master master;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<ReportCard> reportCard;

    @Embedded
    private Term term;





    public Course(Lesson lesson, Master master, Term term) {
        this.lesson = lesson;
        this.master = master;
        this.term = term;
    }

    public Course(Integer integer) {
        super(integer);
    }

    public Course(Integer integer, Lesson lesson, Master master, Term term) {
        super(integer);
        this.lesson = lesson;
        this.master = master;
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course List: " +"\n"+
                "Course ID==> "+ getId()+"\n"+
                "year =======> " + term.getYear().toString() +"\n"+
                "midTerm ====> " +term.getMidTerm().toString()+"\n"+
                "=========================="+"\n";
    }
}
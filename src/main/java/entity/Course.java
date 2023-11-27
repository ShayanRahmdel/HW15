package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
@Entity
public class Course extends BaseEntity<Integer> {

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Master master;

    @OneToMany(mappedBy = "course")
    private Set<ReportCard> reportCard;

    @Embedded
    private Term term;

    @Column(name = "is_pass")
    private Boolean isPass;

}
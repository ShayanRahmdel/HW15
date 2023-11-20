package entity;

import base.entity.PersonBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Master extends User {
    @Column(unique = true,length = 6,nullable = false)
    private String masterNumber;
    @Enumerated(EnumType.STRING)
    private MasterType masterType;

    private Double salary= 1000000.0;
    @OneToMany(mappedBy = "master",cascade = CascadeType.ALL)
    private List<ChosenCourse> chosenCourses;
}

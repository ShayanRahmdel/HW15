package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;


@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
@Entity
@EqualsAndHashCode
public class Lesson extends BaseEntity<Integer> {

    private String title;

    private Integer unit;

    public Lesson(String title, Integer unit) {
        this.title = title;
        this.unit = unit;
    }

    public Lesson(Integer integer, String title, Integer unit) {
        super(integer);
        this.title = title;
        this.unit = unit;
    }

    public Lesson(Integer integer) {
        super(integer);
    }

    @Override
    public String toString() {
        return "Lesson " +"\n"+
                "Lesson ID:" + getId()+"\n"+
                "title : " + title + "\n" +
                "unit:" + unit +"\n"+
                "======================="+"\n";
    }

}
package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
@Entity
public class Lesson extends BaseEntity<Integer> {

    private String title;

    private Integer unit;


}
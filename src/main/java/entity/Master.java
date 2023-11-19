package entity;

import base.entity.PersonBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Master extends PersonBaseEntity<Long> {
    @Column(unique = true,length = 6,nullable = false)
    private String masterNumber;
    @Enumerated(EnumType.STRING)
    private MasterType masterType;
}

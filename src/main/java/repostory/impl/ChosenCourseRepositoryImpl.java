package repostory.impl;

import base.repository.impl.CourseBaseEntityRepositoryImpl;
import entity.ChosenCourse;
import repostory.ChosenCourseRepository;

import javax.persistence.EntityManager;

public class ChosenCourseRepositoryImpl extends CourseBaseEntityRepositoryImpl<ChosenCourse,Integer> implements ChosenCourseRepository {
    public ChosenCourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<ChosenCourse> getEntityClass() {
        return ChosenCourse.class;
    }
}

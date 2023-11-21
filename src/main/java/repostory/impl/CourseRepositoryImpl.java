package repostory.impl;

import base.repository.impl.CourseBaseEntityRepositoryImpl;
import entity.Course;
import repostory.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl extends CourseBaseEntityRepositoryImpl<Course,Integer> implements CourseRepository {
    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}

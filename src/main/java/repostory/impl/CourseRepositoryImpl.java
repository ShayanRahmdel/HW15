package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Course;
import repostory.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("unused")
public class CourseRepositoryImpl extends BaseEntityRepositoryImpl<Course, Integer> implements CourseRepository {


    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }


    @Override
    public Course updateIsPass(Integer courseId) {
        String jpql = "SELECT c FROM Course c WHERE c.id = :courseId";

        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        query.setParameter("courseId", courseId);

        return query.getSingleResult();

    }

//    @Override
//    public Integer findDuplicate(Integer studentId, Integer lessonId, Integer masterId) {
//        String hql = "select c from Course c WHERE c.= :studentId and c.lesson.id= :lessonId and c.master.id= :masterId";
//        TypedQuery<Course> query = entityManager.createQuery(hql, Course.class);
//        query.setParameter("studentId", studentId);
//        query.setParameter("lessonId", lessonId);
//        query.setParameter("masterId", masterId);
//        return query.getFirstResult();
//    }


}

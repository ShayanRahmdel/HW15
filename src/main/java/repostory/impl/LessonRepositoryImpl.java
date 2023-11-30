package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Lesson;

import repostory.LessonRepository;

import javax.persistence.EntityManager;
@SuppressWarnings("unused")
public class LessonRepositoryImpl extends BaseEntityRepositoryImpl<Lesson,Integer> implements LessonRepository {
    public LessonRepositoryImpl(EntityManager entityManager) {
            this.entityManager=entityManager;
    }

    @Override
    public Class<Lesson> getEntityClass() {
        return Lesson.class;
    }
}

package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Lesson;
import repostory.LessonRepository;
import service.LessonService;

@SuppressWarnings("unused")
public class LessonServiceImpl extends BaseEntityServiceImpl<Lesson,Integer, LessonRepository> implements LessonService {

    public LessonServiceImpl(LessonRepository repository) {
        super(repository);
    }

}
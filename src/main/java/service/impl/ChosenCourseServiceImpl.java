package service.impl;

import base.service.impl.CourseBaseEntityServiceImpl;
import entity.ChosenCourse;
import repostory.ChosenCourseRepository;
import service.ChosenCourseService;

public class ChosenCourseServiceImpl extends CourseBaseEntityServiceImpl<ChosenCourse,Integer, ChosenCourseRepository> implements ChosenCourseService {

    public ChosenCourseServiceImpl(ChosenCourseRepository repository) {
        super(repository);
    }
}

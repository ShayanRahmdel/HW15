package service.impl;

import base.service.impl.CourseBaseEntityServiceImpl;
import entity.Course;
import repostory.CourseRepository;
import service.CourseService;

public class CourseServiceImpl extends CourseBaseEntityServiceImpl<Course,Integer, CourseRepository> implements CourseService {

    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }
}

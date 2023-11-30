package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Course;

import repostory.CourseRepository;
import service.CourseService;

@SuppressWarnings("unused")
public class CourseServiceImpl extends BaseEntityServiceImpl<Course,Integer, CourseRepository> implements CourseService {

    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }


    @Override
    public Course updateIsPass(Integer courseId) {
        return repository.updateIsPass(courseId);
    }

//    @Override
//    public Integer findDuplicate(Integer studentID, Integer lessonId, Integer masterId) {
//        return repository.findDuplicate(studentID,lessonId,masterId);
//    }
}
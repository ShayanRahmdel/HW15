package service;


import base.service.BaseService;
import entity.Course;
@SuppressWarnings("unused")
public interface CourseService extends BaseService<Course,Integer> {

    Course updateIsPass(Integer courseId);

//    Integer findDuplicate(Integer studentID,Integer lessonId,Integer masterId);
}
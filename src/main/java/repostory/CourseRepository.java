package repostory;

import base.repository.BaseEntityRepository;
import entity.Course;

public interface CourseRepository
        extends BaseEntityRepository<Course,Integer> {

    Course updateIsPass(Integer courseId);

//    Integer findDuplicate(Integer studentID,Integer lessonId,Integer masterId);

}

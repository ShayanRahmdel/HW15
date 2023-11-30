package service;


import base.service.BaseService;
import entity.*;

import java.util.List;

public interface ReportCardService extends BaseService<ReportCard, Integer> {

    Double getAvg(Student student, Term pervTerm);

    Double findMarkByID(Integer courseID,Integer studentId);
    Long getSumOfUnitsInCurrentTerm(Student student);

    List<ReportCard> findByStudent(Student student);

    List<Course> findCourseByStudent(Student student);

    List<Course> findCourseByStudentAndTeacher(Student student, Master teacher);


    ReportCard findStudentToMark(Integer studentId,Integer courseId,Integer masterId);

}
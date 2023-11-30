package repostory;

import base.repository.BaseEntityRepository;
import entity.*;

import java.util.List;

public interface ReportCardRepository extends BaseEntityRepository<ReportCard,Integer> {

     Double getAvg(Student student, Term pervTerm);

     Double findMarkByID(Integer courseID,Integer studentId);


     Long getSumOfUnitsInCurrentTerm(Student student);

     List<ReportCard> findByStudent(Student student);

     List<Course> findCourseByStudent(Student student);
     List<Course> findCourseByStudentAndTeacher(Student student, Master master);

     ReportCard findStudentToMark(Integer studentId,Integer courseId,Integer masterId);




}

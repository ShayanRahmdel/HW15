package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.*;
import repostory.ReportCardRepository;
import service.ReportCardService;

import java.util.List;

public class ReportCardServiceImpl extends BaseEntityServiceImpl<ReportCard,Integer, ReportCardRepository> implements ReportCardService {

    public ReportCardServiceImpl(ReportCardRepository repository) {
        super(repository);
    }

    @Override
    public Double getAvg(Student student, Term pervTerm) {
        return repository.getAvg(student,pervTerm);
    }

    @Override
    public Double findMarkByID(Integer courseID, Integer studentId) {
        return repository.findMarkByID(courseID,studentId);
    }

    @Override
    public Long getSumOfUnitsInCurrentTerm(Student student) {
        return repository.getSumOfUnitsInCurrentTerm(student);
    }

    @Override
    public List<ReportCard> findByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public List<Course> findCourseByStudent(Student student) {
        return repository.findCourseByStudent(student);
    }

    @Override
    public List<Course> findCourseByStudentAndTeacher(Student student, Master teacher) {
        return repository.findCourseByStudentAndTeacher(student,teacher);
    }

    @Override
    public ReportCard findStudentToMark(Integer studentId, Integer courseId, Integer masterId) {
        return repository.findStudentToMark(studentId,courseId,masterId);
    }


}
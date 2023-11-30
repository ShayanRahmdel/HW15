package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.*;
import repostory.StudentRepository;
import service.ReportCardService;
import service.StudentService;

import java.util.HashSet;
import java.util.Set;

public class StudentServiceImpl extends BaseEntityServiceImpl<Student, Integer, StudentRepository> implements StudentService {

    private final ReportCardService reportCardService;

    public StudentServiceImpl(StudentRepository repository, ReportCardService reportCardService) {
        super(repository);
        this.reportCardService = reportCardService;
    }


    @Override
    public Student findByUserNameAndPasswordReturn(String userName, String password) {
        return repository.findByUserNameAndPasswordReturn(userName, password);
    }

    @Override
    public Boolean findByUserNameAndPassword(String userName, String password) {
        return repository.findByUserNameAndPassword(userName, password);
    }
    boolean isSimilarCourse(Student student, Course course) {
        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.getCourse().getLesson().equals(course.getLesson())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean chooseCourses(Student student, Course course) {
        Term currentTerm = course.getTerm();
        Double previousAvg = reportCardService.getAvg(student, currentTerm.getPervTerm());
        if (previousAvg == null) {
            if (!isSimilarCourse(student, course)) {
                ReportCard reportCard = new ReportCard();
                reportCard.setCourse(course);
                reportCard.setStudent(student);

                reportCardService.saveOrUpdate(reportCard);

                if (student.getReportCards() == null) {

                    student.setReportCards(new HashSet<>());

                }
                student.getReportCards().add(reportCard);

                return true;
            } else {

                System.out.println("Chosen Before");
                return false;
            }
        }
        int maxUnits = (previousAvg > 18) ? 24 : 20;
        if (reportCardService.getSumOfUnitsInCurrentTerm(student) < maxUnits) {
            Set<Lesson> passedLessons = getPassedLessons(student);
            if (!passedLessons.contains(course.getLesson())) {
                if (!isSimilarCourse(student, course)) {
                    ReportCard reportCard = new ReportCard();
                    reportCard.setCourse(course);
                    reportCard.setStudent(student);
                    reportCardService.saveOrUpdate(reportCard);
                    if (student.getReportCards() == null) {

                        student.setReportCards(new HashSet<>());

                    }
                    student.getReportCards().add(reportCard);
                    return true;
                }
            }
        }

        return false;
    }

    private Set<Lesson> getPassedLessons(Student student) {
        Set<Lesson> passedLessons = new HashSet<>();

        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.isPass()) {
                passedLessons.add(studentCourse.getCourse().getLesson());
            }
        }

        return passedLessons;
    }


}

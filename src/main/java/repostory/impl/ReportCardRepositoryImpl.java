package repostory.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.*;
import repostory.ReportCardRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReportCardRepositoryImpl extends BaseEntityRepositoryImpl<ReportCard, Integer> implements ReportCardRepository {
    public ReportCardRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<ReportCard> getEntityClass() {
        return ReportCard.class;
    }

    @Override
    public Double getAvg(Student student,Term pervTerm) {


        String hql = "SELECT avg(mark) FROM ReportCard WHERE student = :student AND course.term.midTerm = :midTerm AND course.term.year = :year";
        TypedQuery<Double> query = entityManager.createQuery(hql, Double.class);
        query.setParameter("student", student);
        query.setParameter("midTerm", pervTerm.getMidTerm());
        query.setParameter("year", pervTerm.getYear());
        return query.getSingleResult();

    }

    @Override
    public Double findMarkByID(Integer courseId, Integer studentId) {
        String pql = "SELECT r.mark FROM ReportCard r WHERE r.student.id = :studentId AND r.course.id = :courseId";

        TypedQuery<Double> query = entityManager.createQuery(pql, Double.class);
        query.setParameter("studentId", studentId);
        query.setParameter("courseId", courseId);

        Double mark = query.getSingleResult();
        return mark;

    }

    @Override
    public Long getSumOfUnitsInCurrentTerm(Student student) {
        Term term = currentTerm(student);
        String hql = """
                SELECT sum(c.lesson.unit) FROM ReportCard rc
                JOIN Course c ON rc.course.id =  c.id
                JOIN Lesson l ON c.lesson.id = l.id
                WHERE rc.student = :student  AND c.term.midTerm = :midTerm AND c.term.year = :year
                """;
        TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
        query.setParameter("student", student);
        query.setParameter("midTerm", term.getMidTerm());
        query.setParameter("year", term.getYear());
        return query.getSingleResult();
    }

    @Override
    public List<ReportCard> findByStudent(Student student) {
        String hql = "SELECT r FROM ReportCard r WHERE r.student = :student";
        TypedQuery<ReportCard> reportCardTypedQuery = entityManager.createQuery(hql, ReportCard.class);
        reportCardTypedQuery.setParameter("student" ,student);
        return reportCardTypedQuery.getResultList();
    }

    @Override
    public List<Course> findCourseByStudent(Student student) {
        String hql = "SELECT course FROM ReportCard r WHERE r.student = :student";
        TypedQuery<Course> reportCardTypedQuery = entityManager.createQuery(hql, Course.class);
        reportCardTypedQuery.setParameter("student", student);
        return reportCardTypedQuery.getResultList();
    }

    @Override
    public List<Course> findCourseByStudentAndTeacher(Student student,Master master) {
            String hql = "SELECT course FROM ReportCard r WHERE r.student = :student AND r.course.master = :teacher";
            TypedQuery<Course> reportCardTypedQuery = entityManager.createQuery(hql, Course.class);
            reportCardTypedQuery.setParameter("student" ,student);
            reportCardTypedQuery.setParameter("teacher" ,master);
            return reportCardTypedQuery.getResultList();
    }

    @Override
    public ReportCard findStudentToMark(Integer studentId, Integer courseId, Integer masterId) {
        String hql="select r FROM ReportCard r inner join Course c on r.course.id=c.id where r.student.id=:studentId and r.course.id=:courseId and c.master.id=:masterId";
        TypedQuery<ReportCard> query = entityManager.createQuery(hql, ReportCard.class);
        query.setParameter("studentId",studentId);
        query.setParameter("courseId",courseId);
        query.setParameter("masterId",masterId);
        return query.getSingleResult();
    }

    public Term currentTerm(Student student) {

        String hql = "SELECT r FROM ReportCard r where r.student.id=:studentId ORDER BY r.id desc ";
        TypedQuery<ReportCard> reportCardTypedQuery = entityManager.createQuery(hql, ReportCard.class);
        reportCardTypedQuery.setParameter("studentId",student.getId());
        reportCardTypedQuery.setMaxResults(1);
        ReportCard reportCard = reportCardTypedQuery.getSingleResult();
        return reportCard.getCourse().getTerm();

    }
}
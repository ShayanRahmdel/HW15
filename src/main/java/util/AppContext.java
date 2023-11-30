package util;

import repostory.*;
import repostory.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppContext {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static final EntityManager ENTITY_MANAGER;

    private static final StudentRepository STUDENT_REPOSITORY;

    private static final StudentService STUDENT_SERVICE;

    private static final MasterRepository MASTER_REPOSITORY;

    private static final MasterService MASTER_SERVICE;

    private static final EmployeeRepository EMPLOYEE_REPOSITORY;

    private static final EmployeeService EMPLOYEE_SERVICE;

    private static final CourseRepository COURSE_REPOSITORY;

    private static final CourseService COURSE_SERVICE;

    private static final LessonRepository LESSON_REPOSITORY;

    private static final ReportCardRepository REPORT_CARD_REPOSITORY;


    private static final LessonService LESSON_SERVICE;
    private static final ReportCardService REPORT_CARD_SERVICE;


    private static final UserRepository USER_REPOSITORY;

    private static final UserService USER_SERVICE;


    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
        STUDENT_REPOSITORY = new StudentRepostoryImpl(ENTITY_MANAGER);
        MASTER_REPOSITORY = new MasterRepositoryImpl(ENTITY_MANAGER);
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(ENTITY_MANAGER);
        COURSE_REPOSITORY = new CourseRepositoryImpl(ENTITY_MANAGER);
        LESSON_REPOSITORY = new LessonRepositoryImpl(ENTITY_MANAGER);
        REPORT_CARD_REPOSITORY = new ReportCardRepositoryImpl(ENTITY_MANAGER);
        USER_REPOSITORY = new UserRepositoryImpl(ENTITY_MANAGER);

        REPORT_CARD_SERVICE = new ReportCardServiceImpl(REPORT_CARD_REPOSITORY);
        USER_SERVICE = new UserServiceImpl(USER_REPOSITORY);
        COURSE_SERVICE = new CourseServiceImpl(COURSE_REPOSITORY);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);
        LESSON_SERVICE = new LessonServiceImpl(LESSON_REPOSITORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY,REPORT_CARD_SERVICE);;
        MASTER_SERVICE = new MasterServiceImpl(MASTER_REPOSITORY);






    }


    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static EmployeeService getEmployeeService() {
        return EMPLOYEE_SERVICE;
    }

    public static MasterService getMasterService() {
        return MASTER_SERVICE;
    }

    public static CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    public static LessonService getLessonService() {
        return LESSON_SERVICE;
    }

    public static ReportCardService getReportCardService() {
        return REPORT_CARD_SERVICE;
    }

    public static void init() {
        System.out.println("initialize dateBase");
    }
}

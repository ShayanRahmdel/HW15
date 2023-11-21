package util;

import repostory.*;
import repostory.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppContext {

        private static final EntityManagerFactory ENTITY_MANAGER_FACTORY ;
        private static final EntityManager ENTITY_MANAGER;

        private static final StudentRepository STUDENT_REPOSITORY;

        private static final StudentService STUDENT_SERVICE;

        private static final MasterRepository MASTER_REPOSITORY;

        private static final MasterService MASTER_SERVICE;

        private static final EmployeeRepository EMPLOYEE_REPOSITORY;

        private static final EmployeeService EMPLOYEE_SERVICE;

        private static final CourseRepository COURSE_REPOSITORY;

        private static final CourseService COURSE_SERVICE;

        private static final ChosenCourseRepository CHOSEN_COURSE_REPOSITORY;

        private static final ChosenCourseService CHOSEN_COURSE_SERVICE;




        static {
             ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");
             ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
             STUDENT_REPOSITORY = new StudentRepostoryImpl(ENTITY_MANAGER);
             STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
             MASTER_REPOSITORY = new MasterRepositoryImpl(ENTITY_MANAGER);
             MASTER_SERVICE = new MasterServiceImpl(MASTER_REPOSITORY);
             EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(ENTITY_MANAGER);
             EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);
             COURSE_REPOSITORY = new CourseRepositoryImpl(ENTITY_MANAGER);
             COURSE_SERVICE = new CourseServiceImpl(COURSE_REPOSITORY);
             CHOSEN_COURSE_REPOSITORY = new ChosenCourseRepositoryImpl(ENTITY_MANAGER);
             CHOSEN_COURSE_SERVICE = new ChosenCourseServiceImpl(CHOSEN_COURSE_REPOSITORY);

        }


        public static StudentService getStudentService(){
            return STUDENT_SERVICE;
        }

        public static EmployeeService getEmployeeService(){
            return EMPLOYEE_SERVICE;
        }

        public static MasterService getMasterService(){
            return MASTER_SERVICE;
        }

        public static CourseService getCourseService(){
            return COURSE_SERVICE;
        }

        public static  ChosenCourseService getChosenCourseService(){
            return CHOSEN_COURSE_SERVICE;
        }
}

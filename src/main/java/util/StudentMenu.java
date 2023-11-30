package util;

import entity.*;

import java.util.*;

public class StudentMenu {
    private Scanner input = new Scanner(System.in);

    public void MainMenu(Student student) {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Show Your Detail");
            System.out.println("2_Show List of Courses");
            System.out.println("3_Choose Course");
            System.out.println("4_show Course and Mark");
            System.out.println("5_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> showStudentDetail(student);
                case 2 -> showAllCourse();
                case 3 -> chooseCourse(student);
                case 4 -> showCourseAndMark(student);
                case 5 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }

    private void showCourseAndMark(Student student) {
        System.out.println(AppContext.getReportCardService().findByStudent(student));
    }

    private void chooseCourse(Student student) {
        System.out.println("enter Course ID:");
        Integer courseId = GiveInput.giveIntegerInput();

        Course course = new Course(courseId);
        if (AppContext.getCourseService().existsById(courseId)) {
            Optional<Course> byId = AppContext.getCourseService().findById(courseId);
            if (AppContext.getStudentService().chooseCourses(student, byId.orElse(null))) {
                System.out.println("ADDED SUCCESSFULLY");
            } else System.out.println("INVALID REQUEST !");
        } else {
            System.out.println("ENTER CORRECT ID");


        }
    }

    private void showAllCourse() {
        System.out.println(AppContext.getCourseService().findAll());
    }

    private void showStudentDetail(Student student) {
        System.out.println(AppContext.getStudentService().findById(student.getId()));
    }


}

package util;

import entity.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenu {
    private Scanner input = new Scanner(System.in);

    public void MainMenu(Student student) {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Show Your Detail");
            System.out.println("2_Show List of Courses");
            System.out.println("3_Choose Course");
            System.out.println("4_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> showStudentDetail(student);
                case 2 -> showAllCourse();
                case 3 -> chooseCourse(student);
                case 4 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }

    private void chooseCourse(Student student) {
        System.out.println("Enter course ID");
        Integer courseId = giveIntegerInput();
        System.out.println("Enter Master ID");
        Integer masterId = giveIntegerInput();
        System.out.println("Select Mid Term");
        String midTerm = giveStringInput();
        MidTerm midTerm1 = null;
        try {
            midTerm1 = MidTerm.valueOf(midTerm);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Mid Term entered. Please try again.");

        }
        Course course = new Course(courseId);
        Master master = new Master(masterId);
        ChosenCourse chosenCourse = new ChosenCourse(course,master,midTerm1);
        student.getChosenCourses().add(chosenCourse);
        AppContext.getChosenCourseService().saveOrUpdate(chosenCourse);

    }

    private void showAllCourse() {
        System.out.println(AppContext.getCourseService().findAll());
    }

    private void showStudentDetail(Student student) {
        System.out.println(AppContext.getStudentService().findById(student.getId()));
    }

    private  String giveStringInput() {
        String i;
        while (true) {
            try {
                i = input.next();

                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just String Please");
            }
        }
    }
    private  Double giveDoubleInput() {
        Double i;
        while (true) {
            try {
                i = input.nextDouble();

                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just Double Please");
            }
        }
    }

    private  Integer giveIntegerInput() {
        int i;
        while (true) {
            try {
                i = input.nextInt();
                input.nextLine();
                return i;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Enter just number Please");
            }
        }
    }
}

package util;

import entity.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMenu {
    private Scanner input = new Scanner(System.in);
    SignUpStudent student = new SignUpStudent();
    EditStudent editStudent = new EditStudent();

    SignUpMaster signUpMaster = new SignUpMaster();

    EditMaster editMaster = new EditMaster();

    SignUpEmployee signUpEmployee = new SignUpEmployee();

    EditEmployee employee = new EditEmployee();

    LessonMenu lessonMenu = new LessonMenu();

    CourseMenu courseMenu = new CourseMenu();

    public void mainMenu(Employee employee) {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Student Menu");
            System.out.println("2_Master Menu");
            System.out.println("3_Employee Menu");
            System.out.println("4_Lesson Menu");
            System.out.println("5_Course Menu");
            System.out.println("6_Show Your Salary");
            System.out.println("7_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> studentMenu();
                case 2 -> masterMenu();
                case 3 -> employeeMenu();
                case 4 -> lessonMenu.Menu();//courseMenu();
                case 5 -> courseMenu();
                case 6 -> showEmployeeDetail(employee);//showSalary();
                case 7 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }

    private void courseMenu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Course");
            System.out.println("2_Delete Course");
            System.out.println("3_Edit Course");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> {
                    try {
                        courseMenu.addCourse();
                    }catch (Exception e){
                        System.out.println("somthing wrong");
                    }
                }
                case 2 -> {
                    try {
                        courseMenu.editCourse();
                    }catch (Exception e){
                        System.out.println("something wrong");
                    }
                }
                case 3 -> {
                    try {
                        courseMenu.deleteCourse();
                    }catch (Exception e){
                        System.out.println("something wrong");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }



    private void studentMenu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Student");
            System.out.println("2_Delete Student");
            System.out.println("3_Edit Student");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> {
                    try {
                        student.addStudent();
                    }catch (Exception e){
                        System.out.println("something Wrong");
                    }
                }
                case 2 -> {
                    try {
                        deleteStudent();
                    }catch (IllegalArgumentException e){
                        System.out.println("not fount this id");
                    }
                }
                case 3 -> {
                    try {
                        editStudent.edit();
                    }catch (IllegalArgumentException e){
                        System.out.println("Something wrong");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }


    private void deleteStudent() {
        System.out.println("Enter student ID:");
        Integer id = GiveInput.giveIntegerInput();
        AppContext.getStudentService().deleteById(id);
    }


    private void masterMenu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Master");
            System.out.println("2_Delete Master");
            System.out.println("3_Edit Master");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> {
                    try {
                        signUpMaster.signUp();
                    }catch (Exception e){
                        System.out.println("something wrong");
                    }
                }
                case 2 -> {
                    try {
                        editMaster.delete();
                    }catch (IllegalArgumentException e){
                        System.out.println("not found id");
                    }
                }
                case 3 -> {
                    try {
                        editMaster.edit();
                    }catch (IllegalArgumentException e){
                        System.out.println("spmething wrong");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }

    private void employeeMenu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Employee");
            System.out.println("2_Delete Employee");
            System.out.println("3_Edit Employee");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> {
                    try {
                        signUpEmployee.signUp();
                    }catch (Exception e){
                        System.out.println("something wrong");
                    }
                }
                case 2 -> {
                    try {
                        employee.delete();
                    }catch (IllegalArgumentException e){
                        System.out.println("wrong Id");
                    }
                }
                case 3 -> {
                    try {
                        employee.edit();
                    }catch (IllegalArgumentException e){
                        System.out.println("something wrong");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }

    }

    private void showEmployeeDetail(Employee employee) {
        System.out.println(AppContext.getEmployeeService().findById(employee.getId()));
    }

}

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

    CourseMenu courseMenu = new CourseMenu();

    public void mainMenu(Employee employee) {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Student Menu");
            System.out.println("2_Master Menu");
            System.out.println("3_Employee Menu");
            System.out.println("4_Course Menu");
            System.out.println("5_Show Your Salary");
            System.out.println("6_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> studentMenu();
                case 2 -> masterMenu();
                case 3 -> employeeMenu();
                case 4 -> courseMenu.courseMenu();//courseMenu();
                case 5 -> showEmployeeDetail(employee);//showSalary();
                case 6 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }

    private Integer giveIntegerInput() {
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

    private void studentMenu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Student");
            System.out.println("2_Delete Student");
            System.out.println("3_Edit Student");
            System.out.println("4_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> student.addStudent();
                case 2 -> deleteStudent();
                case 3 -> editStudent.edit();
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }


    private void deleteStudent(){
        System.out.println("Enter student ID:");
        Integer id = giveIntegerInput();
        AppContext.getStudentService().deleteById(id);
    }


    private void masterMenu(){
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Master");
            System.out.println("2_Delete Master");
            System.out.println("3_Edit Master");
            System.out.println("4_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> signUpMaster.signUp();
                case 2 -> editMaster.delete();
                case 3 -> editMaster.edit();
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }
    private void employeeMenu(){
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Employee");
            System.out.println("2_Delete Employee");
            System.out.println("3_Edit Employee");
            System.out.println("4_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> signUpEmployee.signUp();
                case 2 -> employee.delete();
                case 3 -> employee.edit();
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }

    }

    private void showEmployeeDetail(Employee employee){
        System.out.println(AppContext.getEmployeeService().findById(employee.getId()));
    }

}

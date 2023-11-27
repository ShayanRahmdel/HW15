package util;

import entity.Employee;
import entity.Master;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class SignUpEmployee {
    private Scanner input = new Scanner(System.in);



    public void signUp(){
        System.out.println("Enter FirstName:");
        String firstName = giveStringInput();
        System.out.println("enter LastName:");
        String lastName = giveStringInput();
        System.out.println("Enter UserName:");
        String userName = giveStringInput();
        System.out.println("Enter Password");
        String password = giveStringInput();
        System.out.print("Enter a date (format: dd/MM/yyyy): ");
        String dob = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date= null;
        try {
            date = dateFormat.parse(dob);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
        }
        System.out.println("Enter Email:");
        String email = giveStringInput();
        System.out.println("Enter age:");
        Integer age = giveIntegerInput();
        System.out.println("Enter City:");
        String city = giveStringInput();
        System.out.println("Enter Gender:");
        Character gender = giveCharacterInput();
        System.out.println("Enter Employee tNumber:");
        String employeeNumber = giveStringInput();
        Employee employee = new Employee(firstName,lastName,userName,password,date,email,age,city,gender,employeeNumber);
        validation(employee);
    }


    private static void validation(Employee employee) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // Create a Validator
        Validator validator = validatorFactory.getValidator();

        // Perform validation
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        if (violations.isEmpty()) {
            AppContext.getEmployeeService().saveOrUpdate(employee);
            System.out.println(employee);
        } else {
            for (ConstraintViolation<Employee> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }

    private Character giveCharacterInput() {
        String gender = input.next();

        if (gender.length() == 1) {
            char character = gender.charAt(0);
            return character;

        } else {
            System.out.println("Invalid input. Please enter a single character.");
            return null;
        }

    }


    private String giveStringInput() {
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
    private Double giveDoubleInput() {
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
}
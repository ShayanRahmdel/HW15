package util;

import entity.Employee;

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

public class EditEmployee {


    public void edit() {
        System.out.println("Enter ID for edit");
        Integer id = GiveInput.giveIntegerInput();
        System.out.println("Enter FirstName:");
        String firstName = GiveInput.giveStringInput();
        System.out.println("enter LastName:");
        String lastName = GiveInput.giveStringInput();
        System.out.println("Enter UserName:");
        String userName = ValidInput.userValidation();
        System.out.println("Enter Password");
        String password = ValidInput.validPassword();
        System.out.print("Enter a date (format: dd/MM/yyyy): ");
        String dob = GiveInput.giveStringInput();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dob);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
        }
        System.out.println("Enter Email:");
        String email = GiveInput.giveStringInput();
        System.out.println("Enter age:");
        Integer age = GiveInput.giveIntegerInput();
        System.out.println("Enter City:");
        String city = GiveInput.giveStringInput();
        System.out.println("Enter Gender:");
        Character gender = GiveInput.giveCharacterInput();
        System.out.println("Enter Employee tNumber:");
        String employeeNumber = GiveInput.giveStringInput();
        Employee employee = new Employee(id, firstName, lastName, userName, password, date, email, age, city, gender, employeeNumber);
        validation(employee);
    }


    private static void validation(Employee employee) {

        Set<ConstraintViolation<Employee>> violations = Hibervalidation.validator.validate(employee);
        if (violations.isEmpty()) {
            AppContext.getEmployeeService().saveOrUpdate(employee);
            System.out.println(employee);
        } else {
            for (ConstraintViolation<Employee> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }

    public void delete() {
        System.out.println("Enter Id want to Delete");
        Integer id = GiveInput.giveIntegerInput();
        AppContext.getEmployeeService().deleteById(id);
    }

}

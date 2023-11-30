package util;

import entity.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class SignUpStudent {
    private Scanner input = new Scanner(System.in);

    public void addStudent(){
        System.out.println("Enter FirstName:");
        String firstName = GiveInput.giveStringInput();
        System.out.println("enter LastName:");
        String lastName = GiveInput.giveStringInput();
        System.out.println("Enter UserName:");
        String userName = ValidInput.userValidation();
        System.out.println("Enter Password");
        String password = ValidInput.validPassword();
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
        String email = GiveInput.giveStringInput();
        System.out.println("Enter age:");
        Integer age = GiveInput.giveIntegerInput();
        System.out.println("Enter City:");
        String city = GiveInput.giveStringInput();
        System.out.println("Enter Gender:");
        Character gender = GiveInput.giveCharacterInput();
        System.out.println("Enter StudentNumber:");
        String studentNumber = GiveInput.giveStringInput();
        Student student = new Student(firstName,lastName,userName,password,date,email,age,city,gender,studentNumber);

        Validaion(student);

    }

    private void Validaion (Student  student) {


        Set<ConstraintViolation<Student>> violations = Hibervalidation.validator.validate(student);
        if (violations.isEmpty()) {
            AppContext.getStudentService().saveOrUpdate(student);
            System.out.println(student);
        } else {
            for (ConstraintViolation<Student> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }


}

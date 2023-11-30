package util;

import entity.Master;
import entity.MasterType;
import entity.Student;

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

public class SignUpMaster {
    private Scanner input = new Scanner(System.in);

    public void signUp(){
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
        System.out.println("Enter Master Number:");
        String masterNumber = GiveInput.giveStringInput();
        System.out.print(" Tuition,FacultyMember:");
        String type = GiveInput.giveStringInput();
        MasterType masterType = null;
        try {
            masterType = MasterType.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid rank entered. Please try again.");

        }
        Master master = new Master(firstName,lastName,userName,password,date,email,age,city,gender,masterNumber,masterType);
        validation(master);
    }

    private static void validation(Master master) {
        Set<ConstraintViolation<Master>> violations = Hibervalidation.validator.validate(master);
        if (violations.isEmpty()) {
            AppContext.getMasterService().saveOrUpdate(master);
            System.out.println(master);
        } else {
            for (ConstraintViolation<Master> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }

}

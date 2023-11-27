package util;

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

public class CourseMenu {
    private Scanner input = new Scanner(System.in);





    public void courseMenu(){
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Course");
            System.out.println("2_Delete Course");
            System.out.println("3_Edit Course");
            System.out.println("4_Exit");
            select = giveIntegerInput();
            switch (select) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                case 3 -> editCourse();
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }

    public void addCourse(){
        System.out.println("Enter Name of Course:");
        String name = giveStringInput();
        System.out.println("Enter number of unit:");
        Integer unit = giveIntegerInput();
        System.out.println("Enter Date Release:");
        String releaseDate = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date= null;
        try {
            date = dateFormat.parse(releaseDate);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
        }
        System.out.println("Enter abaout Course:");
        String explain= giveStringInput();
        Course course = new Course(name,unit,date,explain);
        validation(course);

    }
    public void editCourse(){
        System.out.println("Enter Course id want to change:");
        Integer id = giveIntegerInput();
        System.out.println("Enter Name of Course:");
        String name = giveStringInput();
        System.out.println("Enter number of unit:");
        Integer unit = giveIntegerInput();
        System.out.println("Enter Date Release:");
        String releaseDate = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date= null;
        try {
            date = dateFormat.parse(releaseDate);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
        }
        System.out.println("Enter abaout Course:");
        String explain= giveStringInput();
        Course course = new Course(id,name,unit,date,explain);
        validation(course);
    }

    public void removeCourse(){
        System.out.println("Enter ID Course want to Delete:");
        Integer id = giveIntegerInput();
        AppContext.getCourseService().deleteById(id);
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

    public void validation(Course course){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // Create a Validator
        Validator validator = validatorFactory.getValidator();

        // Perform validation
        Set<ConstraintViolation<Course>> violations = validator.validate(course);
        if (violations.isEmpty()) {
            AppContext.getCourseService().saveOrUpdate(course);
            System.out.println(course);
        } else {
            for (ConstraintViolation<Course> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }
}

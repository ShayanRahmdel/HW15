package util;

import entity.Course;
import entity.Lesson;

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

public class LessonMenu {
    private Scanner input = new Scanner(System.in);

    public void Menu() {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Add Lesson");
            System.out.println("2_Delete Lesson");
            System.out.println("3_Edit Lesson");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                case 3 -> editCourse();
                case 4 -> flag = false;
                default -> System.out.println("wrong");

            }
        }
    }

    public void addCourse() {
        System.out.println("Enter title of Lesson:");
        String name = GiveInput.giveStringInput();
        System.out.println("Enter number of unit:");
        Integer unit = GiveInput.giveIntegerInput();

        Lesson lesson = new Lesson(name, unit);
        validation(lesson);

    }

    public void editCourse() {
        System.out.println("Enter lesson id want to change:");
        Integer id = GiveInput.giveIntegerInput();
        System.out.println("Enter title of lesson:");
        String name = GiveInput.giveStringInput();
        System.out.println("Enter number of unit:");
        Integer unit = GiveInput.giveIntegerInput();

        Lesson lesson = new Lesson(id, name, unit);
        validation(lesson);
    }

    public void removeCourse() {
        System.out.println("Enter ID Course want to Delete:");
        Integer id = GiveInput.giveIntegerInput();
        AppContext.getCourseService().deleteById(id);
    }


    public void validation(Lesson lesson) {

        Set<ConstraintViolation<Lesson>> violations = Hibervalidation.validator.validate(lesson);
        if (violations.isEmpty()) {
            AppContext.getLessonService().saveOrUpdate(lesson);
            System.out.println(lesson);
        } else {
            for (ConstraintViolation<Lesson> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
    }
}

package util;

import entity.*;

public class CourseMenu {


    public void addCourse(){
        System.out.println("Enter Lesson ID");
        Integer lessonId = GiveInput.giveIntegerInput();
        System.out.println("Enter Master ID");
        Integer masterId = GiveInput.giveIntegerInput();
        System.out.println("Enter Year");
        Integer year = GiveInput.giveIntegerInput();
        System.out.println("Select Mid Term");
        String midTerm = GiveInput.giveStringInput();
        MidTerm midTerm1 = null;
        try {
            midTerm1 = MidTerm.valueOf(midTerm);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Mid Term entered. Please try again.");

        }
        Lesson lesson = new Lesson(lessonId);
        Master master = new Master(masterId);
        Term term = new Term(year,midTerm1);
        Course course = new Course(lesson,master,term);
        AppContext.getCourseService().saveOrUpdate(course);
    }

    public void editCourse(){
        System.out.println("Enter ID course to Change:");
        Integer courseId = GiveInput.giveIntegerInput();
        System.out.println("Enter Lesson ID");
        Integer lessonId = GiveInput.giveIntegerInput();
        System.out.println("Enter Master ID");
        Integer masterId = GiveInput.giveIntegerInput();
        System.out.println("Enter Year");
        Integer year = GiveInput.giveIntegerInput();
        System.out.println("Select Mid Term");
        String midTerm = GiveInput.giveStringInput();
        MidTerm midTerm1 = null;
        try {
            midTerm1 = MidTerm.valueOf(midTerm);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Mid Term entered. Please try again.");

        }
        Lesson lesson = new Lesson(lessonId);
        Master master = new Master(masterId);
        Term term = new Term(year,midTerm1);
        Course course = new Course(courseId,lesson,master,term);
        AppContext.getCourseService().saveOrUpdate(course);

    }

    public void deleteCourse(){
        System.out.println("Enter course want to delete:");
        Integer courseId = GiveInput.giveIntegerInput();
        AppContext.getCourseService().deleteById(courseId);

    }
}

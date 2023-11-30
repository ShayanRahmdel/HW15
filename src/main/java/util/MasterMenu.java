package util;

import entity.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MasterMenu {
    private Scanner input = new Scanner(System.in);

    public void menu(Master master) {
        Boolean flag = true;
        Integer select = 0;
        while (flag) {
            System.out.println("1_Show Your Detail");
            System.out.println("2_Mark Your Student");
            System.out.println("3_Show Your Salary");
            System.out.println("4_Exit");
            select = GiveInput.giveIntegerInput();
            switch (select) {
                case 1 -> showMasterDetail(master);
                case 2 -> {
                    try {
                        markStudent(master);
                    }catch (Exception e){
                        System.out.println("something wrong");
                    }
                }
                case 3 ->{
                    try {
                        showMasterSalary(master);
                        System.out.println("enter valid year");
                    }catch (Exception e){
                        System.out.println("invalid Year");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("wrong");
            }
        }
    }

    private void showMasterSalary(Master master) {
        System.out.println("Enter Your Term year");
        Integer year = GiveInput.giveIntegerInput();
        System.out.println("Select Mid Term");
        String midTerm = GiveInput.giveStringInput();
        MidTerm midTerm1 = null;
        try {
            midTerm1 = MidTerm.valueOf(midTerm);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Mid Term entered. Please try again.");

        }
        Term term = new Term(year,midTerm1);
        Long unitInTerm = AppContext.getMasterService().findUnitInTerm(master.getId(),term);
        Double salary = null;
        if (master.getMasterType().equals(MasterType.FacultyMember)) {
            int facultySalary = 5000000;
            salary = unitInTerm * master.getSalary() + facultySalary;
            System.out.println(master.getFirstName() + " \n" + master.getLastName() + "\n" +
                    "Your total salary ========> " + salary);
            String showSalaryDetail = "===================="+"\n"+
                    "Number of Unit : "+ unitInTerm+"\n"+
                    "Salary Per Unit:" + master.getSalary()+"\n"+
                    "Salary for memberShip: "+ facultySalary +"\n"+
                    "============================================";
            System.out.println(showSalaryDetail);

        } else if (master.getMasterType().equals(MasterType.Tuition)) {
            salary = unitInTerm * master.getSalary();
            System.out.println(master.getFirstName() + " \n" + master.getLastName() + "\n" +
                    "Your number of unit in this term ======> " + unitInTerm + "\n" + "Your salary ========> " + salary);
            String showSalaryDetail = "===================="+"\n"+
                    "Number of Unit : "+ unitInTerm+"\n"+
                    "Salary Per Unit:" + master.getSalary()+"\n"+
                    "=========================================";
            System.out.println(showSalaryDetail);
        }

    }

    private void markStudent(Master master) {
        System.out.println("Enter Student ID:");
        Integer studentId = GiveInput.giveIntegerInput();
        System.out.println("Enter Course ID:");
        Integer courseId = GiveInput.giveIntegerInput();
        System.out.println("Enter Your Mark:");
        Double mark = GiveInput.giveDoubleInput();


        ReportCard reportCard = AppContext.getReportCardService().findStudentToMark(studentId, courseId, master.getId());

        reportCard.setMark(mark);

        AppContext.getReportCardService().saveOrUpdate(reportCard);
    }


    private void showMasterDetail(Master master) {
        System.out.println(AppContext.getMasterService().findById(master.getId()));
    }

}

package util;

import entity.Employee;
import entity.Master;
import entity.Student;
import entity.User;

import javax.persistence.NoResultException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private Scanner input = new Scanner(System.in);

    private EmployeeMenu employeeMenu = new EmployeeMenu();
    private StudentMenu studentMenu = new StudentMenu();
    private MasterMenu masterMenu = new MasterMenu();


    public void main() {
        AppContext.init();


        System.out.println("Enter Your username");
        String userName = GiveInput.giveStringInput();
        System.out.println("Enter Your Password");
        String password = GiveInput.giveStringInput();
        User user = new User();
        try {
             user = AppContext.getUserService().findByUsernameAndPassword(userName, password);
        }catch (NoResultException e){
            System.out.println("not found this user");
        }



        if (user instanceof Employee) {
            Employee employee = AppContext.getEmployeeService().findByUserNameAndPasswordReturn(userName, password);
            employeeMenu.mainMenu(employee);
        }
        if (user instanceof Student) {
            Student student = AppContext.getStudentService().findByUserNameAndPasswordReturn(userName, password);
            studentMenu.MainMenu(student);
        }
        if (user instanceof Master) {
            Master master = AppContext.getMasterService().findByUserNameAndPassword(userName, password);
            masterMenu.menu(master);
        } else System.out.println("Please try again");
    }

}

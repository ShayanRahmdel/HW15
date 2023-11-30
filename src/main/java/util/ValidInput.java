package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidInput {
    private static Scanner input = new Scanner(System.in);


    public static Boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");
        return password.matches(pattern.pattern());
    }

    public static Boolean isValidUserName(String userName){
        Pattern pattern = Pattern.compile("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
        return userName.matches(pattern.pattern());
    }

    public static Boolean isValidName(String name){
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z '.-]*[A-Za-z][^-]$");
        return name.matches(pattern.pattern());
    }

    public static String validPassword() {
        String password = " ";
        boolean flag = true;
        while (flag){
            password = input.next();
            if (ValidInput.isValidPassword(password)){
                flag = false;
            }else System.out.println("enter valid password");
        }
        return password;
    }

    public static String userValidation() {
        String userName="";
        boolean flag = true;
        while (flag){
            userName = input.next();
            if (ValidInput.isValidUserName(userName)){
                flag = false;
            }else System.out.println("enter valid userName");
        }
        return userName;
    }
}

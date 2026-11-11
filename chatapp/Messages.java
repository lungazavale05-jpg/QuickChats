package chatapp;

import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {
        Login log = new Login();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username");
        String username = scanner.nextLine();
        if (log.checkUsername(username)) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

        System.out.println("Enter password");
        String password = scanner.nextLine();
        if (log.checkPasswordComplexity(password)) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        if (log.checkCellPhoneNumber(phone)) {
            System.out.println("Phone number is correct");
        } else {
            System.out.println("Phone number is incorrect");
        }

        System.out.println("Welcome back to the chatapp");
        
        // Start the QuickChat menu
        Messages app = new Messages();
        app.part(); 
    }
}

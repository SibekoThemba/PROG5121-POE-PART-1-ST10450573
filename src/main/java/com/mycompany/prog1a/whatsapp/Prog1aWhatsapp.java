package com.mycompany.prog1a.whatsapp;

import java.util.Scanner;

public class Prog1aWhatsapp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        String username;
        String password;
        String cellPhone;

        // REGISTRATION
        System.out.println("=== Register ===");

        System.out.print("Enter username: ");
        username = input.nextLine();

        System.out.print("Enter password: ");
        password = input.nextLine();

        System.out.print("Enter SA cell number (+27...): ");
        cellPhone = input.nextLine();

        String registrationMessage = login.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        // ONLY continue if registration was successful
        if (registrationMessage.equals("User successfully registered.")) {

            // LOGIN
            System.out.println("\n=== Login ===");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            String loginMessage = login.returnLoginStatus(loginSuccess);

            System.out.println(loginMessage);

        } else {
            System.out.println("Registration failed. Please restart the program.");
        }
    }
}
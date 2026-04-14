package com.mycompany.prog1a.whatsapp;

public class Login {

    private String username;
    private String password;
    private String cellPhone;

    // Check Username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check Password Complexity
    public boolean checkPasswordComplexity(String password) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // Check Cell Phone Number
    public boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone.startsWith("+27") && cellPhone.length() <= 12;
    }

    // Register User
    public String registerUser(String username, String password, String cellPhone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // Save details ONLY if everything is correct
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;

        return "User successfully registered.";
    }

    // Login User
    public boolean loginUser(String username, String password) {

        // Prevent crash if user never registered
        if (this.username == null || this.password == null) {
            return false;
        }

        return this.username.equals(username) && this.password.equals(password);
    }

    // Return Login Status
    public String returnLoginStatus(boolean loginSuccess) {

        if (loginSuccess) {
            return "Welcome user, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // Username message
    public String getUserNameMessage(String username) {
    if (checkUserName(username)) {
        return "Username successfully captured.";
    } else {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    }

    // Password message
    public String getPasswordMessage(String password) {
    if (checkPasswordComplexity(password)) {
        return "Password successfully captured.";
    } else {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    }

    // Cellphone message
    public String getCellPhoneMessage(String cellPhone) {
    if (checkCellPhoneNumber(cellPhone)) {
        return "Cell number successfully captured.";
    } else {
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
}
}
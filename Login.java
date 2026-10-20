/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author ukulu
 */
public class Login {
         public  boolean checkUsername(String username) {

            if (username.contains("_") && username.length() <= 5) {
                return true;
            } else {
                return false;
            }
        }

        public  boolean checkPasswordComplexity(String password) {
            boolean length = password.length() >= 8;
            boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
            boolean hasDigit = password.chars().anyMatch(Character::isDigit);
            boolean hasSpecial = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
            return length && hasUpper && hasDigit && hasSpecial;
        }

        public  boolean checkCellPhoneNumber(String CellPhoneNumber) {
            String regex = "^\\+27[0-9]{9}$";

            return CellPhoneNumber.matches(regex);
        }

        public String registerUser(String username, String password, String cellnum) {
            boolean IsUsernameCorrect = checkUsername(username);
            boolean IsPasswordCorrect = checkPasswordComplexity(password);
            boolean IsPhoneNumberCorrect = checkCellPhoneNumber(cellnum);

            if (!IsUsernameCorrect) {
                return "Username is formated correctly";
            }
            if (!IsPasswordCorrect) {

                return "Password does not meet thecorrect complexity ";
            }

            if (!IsPhoneNumberCorrect) {
            }
            return "PhoneNumber does not meet the correct complexity ";
        }

    public boolean loginUser(String username, String password, String newUsername, String newPassword){
        if(username.equals(newUsername) && password.equals(newPassword)){
            return true;
        }else{
            return false;
        }
    }

    public String returnLoginStatus(boolean LoginSuccessful) {
        if (LoginSuccessful) {
            return "Welcome back , your Login Successful.";
        } else {
            return "Login Failed , Please check username and password";

        }
        
    }
}

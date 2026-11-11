package chatapp;

public class Login {
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        return length && hasUpper && hasDigit && hasSpecial;
    }
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        String regex = "^\\+27[0-9]{9}$";
        return cellPhoneNumber.matches(regex);
    }
    public String registerUser(String username, String password, String cellnum) {
        boolean isUsernameCorrect = checkUsername(username);
        boolean isPasswordCorrect = checkPasswordComplexity(password);
        boolean isPhoneNumberCorrect = checkCellPhoneNumber(cellnum);
        if (!isUsernameCorrect) return "Username is incorrectly formatted.";
        if (!isPasswordCorrect) return "Password does not meet the complexity requirements.";
        if (!isPhoneNumberCorrect) return "Phone number must start with +27 followed by 9 digits.";
        return "User registered successfully!";
    }
    public boolean loginUser(String username, String password, String newUsername, String newPassword) {
        return username.equals(newUsername) && password.equals(newPassword);
    }
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) return "Welcome back, your Login Successful.";
        else return "Login Failed, Please check username and password";
    }
}

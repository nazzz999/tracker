package ru.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            } else {
                containsSpecialCharacter = true;
            }
        }
        if (!containsUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (!containsLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (!containsDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!containsSpecialCharacter) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String lowerCasePassword = password.toLowerCase();

        for (String forbidden : FORBIDDEN) {
            if (lowerCasePassword.contains(forbidden)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}

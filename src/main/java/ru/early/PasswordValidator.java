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
        if (!containsUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (!containsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!containsSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        if (containsForbiddenSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
    return password;
    }

        private static boolean containsUpperCase(String password) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean containsLowerCase(String password) {
            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean containsDigit(String password) {
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean containsSpecialCharacter(String password) {
            for (char c : password.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean containsForbiddenSubstring(String password) {
            String lowerCasePassword = password.toLowerCase();
            for (String forbidden : FORBIDDEN) {
                if (lowerCasePassword.contains(forbidden)) {
                    return true; // Найдена запрещенная подстрока
                }

            }
            return false;
        }

}

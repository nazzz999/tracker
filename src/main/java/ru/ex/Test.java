package ru.ex;

public class Test {
    public static void throwException() throws UserNotFoundException {
        throw new UserNotFoundException("Error");
    }

    public static void throwExceptionTwo() throws UserNotFoundException {
        throw new UserNotFoundException("Error2");
    }

    public static void test() {
        try {
            throwException();
            throwExceptionTwo();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        test();
    }
}

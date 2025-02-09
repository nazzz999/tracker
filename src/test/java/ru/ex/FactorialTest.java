package ru.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    public void whenExceptionWithAnError() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Factorial.calc(-2);
                });
        assertThat(exception.getMessage()).isEqualTo("Сообщение об ошибке");
    }

    @Test
    public void whenExceptionWithoutError() {
        int number = 3;
        int expected = 6;
        int result = Factorial.calc(number);
        assertThat(result).isEqualTo(expected);
    }
}
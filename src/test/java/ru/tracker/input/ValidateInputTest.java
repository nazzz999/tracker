package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(List.of("one", "1"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputThenReturnParsedInt() {
        Output output = new MockOutput();
        Input in = new MockInput(List.of("6"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    public void whenMultipleValidInputsThenReturnCorrectInt() {
        Output output = new MockOutput();
        Input in = new MockInput(List.of("1", "2", "3"));
        ValidateInput input = new ValidateInput(output, in);
        int firstSelected = input.askInt("Enter menu:");
        assertThat(firstSelected).isEqualTo(1);

        int secondSelected = input.askInt("Enter menu:");
        assertThat(secondSelected).isEqualTo(2);

        int thirdSelected = input.askInt("Enter menu:");
        assertThat(thirdSelected).isEqualTo(3);
    }

    @Test
    public void whenNegativeInputThenReturnParsedNegativeInt() {
        Output output = new MockOutput();
        Input in = new MockInput(List.of("-5"));
        ValidateInput input = new ValidateInput(output, in);

        int selected = input.askInt("Enter menu:");

        assertThat(selected).isEqualTo(-5);
    }

}
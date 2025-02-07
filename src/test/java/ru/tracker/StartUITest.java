package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0", "1", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Nastya"));
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
        assertThat(tracker.findAll()[0].getId()).isEqualTo(1);
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Nastya"));
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1)).isNull();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }
}
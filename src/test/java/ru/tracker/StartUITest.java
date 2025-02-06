package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Input input = new MockInput(
                new String[] {"0", "1", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Nastya"));
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
        assertThat(tracker.findAll()[0].getId()).isEqualTo(1);
    }

    @Test
    void whenDeleteItem() {
        Input input = new MockInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Nastya"));
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(1)).isNull();
    }
}
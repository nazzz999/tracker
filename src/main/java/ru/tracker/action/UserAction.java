package ru.tracker.action;

import ru.tracker.Input;
import ru.tracker.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}

package ru.tracker;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void testSortItemsAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banana"));
        items.add(new Item("Apple"));
        items.add(new Item("Cherry"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Apple"));
        expected.add(new Item("Banana"));
        expected.add(new Item("Cherry"));

        Collections.sort(items, new ItemAscByName());

        Assertions.assertThat(items).isEqualTo(expected);
    }

    @Test
    public void testSortItemsDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banana"));
        items.add(new Item("Apple"));
        items.add(new Item("Cherry"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Cherry"));
        expected.add(new Item("Banana"));
        expected.add(new Item("Apple"));

        Collections.sort(items, new ItemDescByName());

        Assertions.assertThat(items).isEqualTo(expected);
    }
}
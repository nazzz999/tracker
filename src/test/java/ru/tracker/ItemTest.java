package ru.tracker;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemTest {

    @Test
    public void testSortItemsAsc() {
        List<Item> items = new ArrayList<>();
        Item item = new Item("Banana");
        Item item1 = new Item("Apple");
        Item item2 = new Item("Cherry");
        items.add(item);
        items.add(item1);
        items.add(item2);
        items.sort(new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item);
        expected.add(item2);

        Assertions.assertThat(items).isEqualTo(expected);
    }

    @Test
    public void testSortItemsDesc() {
        List<Item> items = new ArrayList<>();
        Item item = new Item("Banana");
        Item item1 = new Item("Apple");
        Item item2 = new Item("Cherry");
        items.add(item);
        items.add(item1);
        items.add(item2);

        items.sort(new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(item2);
        expected.add(item);
        expected.add(item1);

        Assertions.assertThat(items).isEqualTo(expected);
    }
}
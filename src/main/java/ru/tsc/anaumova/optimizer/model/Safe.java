package ru.tsc.anaumova.optimizer.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Safe {

    private final int capacity;

    @NotNull
    private final List<Item> items = new ArrayList<>();

    public Safe(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @NotNull
    public List<Item> getItems() {
        return items;
    }

    public void addItemToSafe(@NotNull final Item item) {
        items.add(item);
    }

}

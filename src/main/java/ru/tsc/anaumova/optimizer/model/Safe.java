package ru.tsc.anaumova.optimizer.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Safe {

    private int capacity;

    @NotNull
    protected List<Item> items = new ArrayList<>();

    public void setCapacity(int capacity) {
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

    public void clearSafe() {
        items.clear();
    }

}

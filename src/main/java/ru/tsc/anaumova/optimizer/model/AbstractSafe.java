package ru.tsc.anaumova.optimizer.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AbstractSafe {

    protected int capacity;

    @NotNull
    protected List<AbstractItem> items = new ArrayList<>();

    public AbstractSafe(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @NotNull
    public List<AbstractItem> getItems() {
        return items;
    }

}

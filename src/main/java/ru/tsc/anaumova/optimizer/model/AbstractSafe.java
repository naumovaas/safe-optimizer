package ru.tsc.anaumova.optimizer.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractSafe {

    private static int count = 0;

    protected int id;

    protected int capacity;

    protected List<AbstractItem> items = new ArrayList<>();

    public AbstractSafe(int capacity) {
        this.capacity = capacity;
        this.id = count;
        count++;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public List<AbstractItem> getItems() {
        return items;
    }

    public void setItems(List<AbstractItem> items) {
        this.items = items;
    }

}

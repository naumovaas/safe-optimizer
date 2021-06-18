package ru.tsc.anaumova.optimizer.model;

import org.jetbrains.annotations.Nullable;

public class AbstractItem {

    @Nullable
    protected String title;

    protected int size;

    protected int cost;

    public AbstractItem(String title, int size, int cost) {
        this.title = title;
        this.size = size;
        this.cost = cost;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "title: " + title + "; cost: " + cost + "; size: " + size + ";";
    }

}

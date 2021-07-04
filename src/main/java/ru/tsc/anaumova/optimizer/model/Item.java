package ru.tsc.anaumova.optimizer.model;

import org.jetbrains.annotations.Nullable;

public class Item {

    @Nullable
    private final String title;

    private final int size;

    private final int cost;

    public Item(@Nullable String title, int size, int cost) {
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

    @Nullable
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title: " + title + "; cost: " + cost + "; size: " + size + ";";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
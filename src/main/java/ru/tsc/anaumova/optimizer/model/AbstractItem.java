package ru.tsc.anaumova.optimizer.model;

public class AbstractItem {

    protected String title;

    protected int size;

    protected int cost;

    public AbstractItem(String title, int size, int cost) {
        this.title = title;
        this.size = size;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int volume) {
        this.size = volume;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "title: " + title + "; cost: " + cost + "; size: " + size + ";";
    }
}

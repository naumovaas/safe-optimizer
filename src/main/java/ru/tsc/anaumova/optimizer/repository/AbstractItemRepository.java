package ru.tsc.anaumova.optimizer.repository;

import ru.tsc.anaumova.optimizer.model.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public class AbstractItemRepository implements IAbstractItemRepository {

    protected List<AbstractItem> list = new ArrayList<>();

//    @Override
//    public void add (AbstractItem item){
//        list.add(item);
//    }
//
//    @Override
//    public void addAll(List<AbstractItem> items) {
//        list.addAll(items);
//    }

    @Override
    public List<AbstractItem> getAll() {
        return list;
    }
}

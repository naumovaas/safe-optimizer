package ru.tsc.anaumova.optimizer.repository;

import ru.tsc.anaumova.optimizer.model.AbstractItem;

import java.util.List;

public interface IAbstractItemRepository {

//    void add (AbstractItem item);
//
//    void addAll(List<AbstractItem> items);

    List<AbstractItem> getAll();

}

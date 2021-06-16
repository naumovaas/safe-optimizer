package ru.tsc.anaumova.optimizer.repository;

import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.AbstractSafe;

import java.util.ArrayList;
import java.util.List;

public class AbstractSafeRepository implements IAbstractSafeRepository{

    protected List<AbstractSafe> list = new ArrayList<>();

//    @Override
//    public void add(AbstractSafe safe) {
//        list.add(safe);
//    }
//
//    @Override
//    public void addAll(List<AbstractSafe> safes) {
//        list.addAll(safes);
//    }
//
//    @Override
//    public List<AbstractSafe> getAll() {
//        return list;
//    }

    @Override
    public AbstractSafe getSafeById(int id) {
        return list.get(id);
    }

}

package ru.tsc.anaumova.optimizer.repository;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public class AbstractItemRepository implements IAbstractItemRepository {

    @NotNull
    protected List<AbstractItem> list = new ArrayList<>();

    @Override
    @NotNull
    public List<AbstractItem> getAll() {
        return list;
    }

}
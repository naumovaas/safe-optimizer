package ru.tsc.anaumova.optimizer.repository;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItemRepository implements IAbstractItemRepository {

    @NotNull
    protected List<Item> list = new ArrayList<>();

    @Override
    @NotNull
    public abstract List<Item> getAll();

}
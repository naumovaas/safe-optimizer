package ru.tsc.anaumova.optimizer.repository;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public interface IAbstractItemRepository {

    @NotNull
    List<Item> getAll();

}

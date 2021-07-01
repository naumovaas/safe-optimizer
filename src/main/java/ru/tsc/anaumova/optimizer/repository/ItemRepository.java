package ru.tsc.anaumova.optimizer.repository;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public interface ItemRepository {

    @NotNull
    List<Item> getAll();

}

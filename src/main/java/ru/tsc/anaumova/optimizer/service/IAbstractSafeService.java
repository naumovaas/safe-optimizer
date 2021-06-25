package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

public interface IAbstractSafeService {

    void addItemToSafe(@NotNull final Item item);

    Safe getSafe();

    List<Item> getItemsFromSafe();

}

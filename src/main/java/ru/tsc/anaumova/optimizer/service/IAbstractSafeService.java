package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

public interface IAbstractSafeService {

    void addItemToSafe(@NotNull final Item item);

}

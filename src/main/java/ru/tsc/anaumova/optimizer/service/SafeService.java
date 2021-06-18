package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

public class SafeService extends AbstractSafeService{

    public SafeService(Safe safe) {
        super(safe);
    }

    @Override
    public void addItemToSafe(@NotNull final Item item) {
        safe.getItems().add(item);
    }

}
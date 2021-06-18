package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.AbstractSafe;

public class AbstractSafeService implements IAbstractSafeService{

    @NotNull
    private final AbstractSafe safe;

    public AbstractSafeService(AbstractSafe safe) {
        this.safe = safe;
    }

    @Override
    public void addItemToSafe(@NotNull final AbstractItem item) {
        safe.getItems().add(item);
    }

}

package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

public abstract class AbstractSafeService implements IAbstractSafeService{

    @NotNull
    protected final Safe safe;

    public AbstractSafeService(Safe safe) {
        this.safe = safe;
    }

    @Override
    public abstract void addItemToSafe(@NotNull final Item item);

}

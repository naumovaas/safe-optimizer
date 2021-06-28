package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Safe;

public abstract class AbstractSafeService implements IAbstractSafeService{

    @NotNull
    protected final Safe safe;

    public AbstractSafeService(@NotNull Safe safe) {
        this.safe = safe;
    }

}

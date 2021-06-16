package ru.tsc.anaumova.optimizer.service;

import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.AbstractSafe;

public class AbstractSafeService {

    private final AbstractSafe safe;

    public AbstractSafeService(AbstractSafe safe) {
        this.safe = safe;
    }

    public void addItemToSafe(AbstractItem item) {
        safe.getItems().add(item);
    }

}

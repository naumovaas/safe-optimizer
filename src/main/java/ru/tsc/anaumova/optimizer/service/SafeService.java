package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Component
public class SafeService extends AbstractSafeService{

    public SafeService(Safe safe) {
        super(safe);
    }

    @Override
    public void addItemToSafe(@NotNull final Item item) {
        safe.getItems().add(item);
    }

    @Override
    public Safe getSafe() {
        return safe;
    }

    @Override
    public List<Item> getItemsFromSafe() {
        return safe.getItems();
    }

}
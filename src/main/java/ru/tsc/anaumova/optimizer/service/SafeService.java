package ru.tsc.anaumova.optimizer.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Service
public class SafeService extends AbstractSafeService{

    public SafeService() {
        super(new Safe(10));
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

    @Override
    public void cleanSafe() {
        for (int i = safe.getItems().size() - 1; i >= 0; i--)
            safe.getItems().remove(i);
    }

}
package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;

public class Bootstrap {

    @NotNull
    private final IAbstractItemRepository itemRepository = new ItemRepository("items.json");

    @NotNull
    private final Safe safe = new Safe(10);

    public void start(){
        Optimizer optimizer = new Optimizer(itemRepository, safe);
        final int[][] matrix = optimizer.calcMatrix(safe.getCapacity());
        optimizer.findResult(matrix);
        System.out.println(safe.getItems());
    }

}
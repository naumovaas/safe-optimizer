package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;
import ru.tsc.anaumova.optimizer.service.IAbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

import java.util.List;

public class Bootstrap {

    @NotNull
    private static final IAbstractItemRepository itemRepository = new ItemRepository("items.json");

    @NotNull
    private static final List<Item> items = itemRepository.getAll();

    @NotNull
    private static final Safe safe = new Safe(10);

    @NotNull
    private static final IAbstractSafeService safeService = new SafeService(safe);

    @NotNull
    public static List<Item> getItems() {
        return items;
    }

    @NotNull
    public static IAbstractSafeService getSafeService() {
        return safeService;
    }

    public static void start(){
        final int[][] matrix = Optimizer.calcMatrix(items, safe.getCapacity());
        Optimizer.findResult(matrix);

        System.out.println(safe.getItems());
    }

}
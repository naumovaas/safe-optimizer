package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;
import ru.tsc.anaumova.optimizer.service.AbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

import java.util.List;

public class Bootstrap {

    @NotNull
    private static final IAbstractItemRepository itemRepository = new ItemRepository();

    @NotNull
    private static final List<AbstractItem> items = itemRepository.getAll();

    @NotNull
    private static final Safe safe = new Safe(10);

    @NotNull
    private static final AbstractSafeService safeService = new SafeService(safe);

    public static List<AbstractItem> getItems() {
        return items;
    }

    public static AbstractSafeService getSafeService() {
        return safeService;
    }

    public static Safe getSafe() {
        return safe;
    }

    public static void start(){
        final int[][] matrix = Optimizer.calcMatrix();
        Optimizer.findResult(matrix);

        System.out.println(safe.getItems());
    }

}
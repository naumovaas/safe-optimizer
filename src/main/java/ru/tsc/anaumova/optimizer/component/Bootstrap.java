package ru.tsc.anaumova.optimizer.component;

import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.AbstractSafe;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;
import ru.tsc.anaumova.optimizer.service.AbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

import java.util.List;

public class Bootstrap {

    private static final IAbstractItemRepository itemRepository = new ItemRepository();

    private static final List<AbstractItem> items = itemRepository.getAll();

    private static final Safe safe = new Safe(10);

    private static final AbstractSafeService safeService = new SafeService(safe);

    public static List<AbstractItem> getItems() {
        return items;
    }

    public static AbstractSafeService getSafeService() {
        return safeService;
    }

    public static void start(){
        int[][] matrix = Optimizer.calcMatrix(items, safe.getCapacity());
        Optimizer.findResult(matrix);

        System.out.println(safe.getId());
        System.out.println(safe.getCapacity());
        System.out.println(safe.getItems());

    }

}
package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;
import ru.tsc.anaumova.optimizer.service.AbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

import java.util.List;

@Component
public class Bootstrap {

    @NotNull
    private final IAbstractItemRepository itemRepository = new ItemRepository("items.json");

    @NotNull
    private final AbstractSafeService safeService = new SafeService(new Safe(10));

    public List<Item> start(){
        optimizeSafe();
        return safeService.getItemsFromSafe();
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(){
        List<Item> items = itemRepository.getAll();
        MatrixCalculator matrixCalculator = new MatrixCalculator(items, safeService.getSafe());
        Optimizer optimizer = new Optimizer(items, safeService.getSafe());
        int[][] matrix = matrixCalculator.calcMatrix();
        optimizer.findResult(matrix);
    }

}
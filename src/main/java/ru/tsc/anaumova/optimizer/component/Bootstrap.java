package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;

import java.util.List;

public class Bootstrap {

    @NotNull
    private final IAbstractItemRepository itemRepository = new ItemRepository("items.json");

    @NotNull
    private final Safe safe = new Safe(10);

    public void start(){
        optimizeSafe();
        System.out.println(safe.getItems());
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(){
        List<Item> items = itemRepository.getAll();
        MatrixCalculator matrixCalculator = new MatrixCalculator(items, safe);
        Optimizer optimizer = new Optimizer(items, safe);
        int[][] matrix = matrixCalculator.calcMatrix();
        optimizer.findResult(matrix);
    }

}
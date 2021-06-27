package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.service.*;

import java.util.List;

@Component
public class Bootstrap {

    @NotNull
    private final IItemService itemService;

    @NotNull
    private final IAbstractSafeService safeService;

    @Autowired
    public Bootstrap(@NotNull IItemService itemService, @NotNull IAbstractSafeService safeService) {
        this.itemService = itemService;
        this.safeService = safeService;
    }

    public List<Item> start(){
        optimizeSafe();
        return safeService.getItemsFromSafe();
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(){
        List<Item> items = itemService.getAll();
        MatrixCalculator matrixCalculator = new MatrixCalculator(items, safeService.getSafe());
        Optimizer optimizer = new Optimizer(items, safeService.getSafe());
        int[][] matrix = matrixCalculator.calcMatrix();
        optimizer.findResult(matrix);
    }

}
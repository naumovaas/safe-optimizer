package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Component
public class Bootstrap {

    public List<Item> startOptimize(final List<Item> items, final Safe safe){
        MatrixCalculator matrixCalculator = new MatrixCalculator(items, safe);
        Optimizer optimizer = new Optimizer(items, safe);
        optimizeSafe(matrixCalculator, optimizer);
        return safe.getItems();
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(@NotNull MatrixCalculator matrixCalculator, @NotNull Optimizer optimizer){
        int[][] matrix = matrixCalculator.calc();
        optimizer.findResult(matrix);
    }

}
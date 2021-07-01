package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Component
public class Bootstrap {

    @NotNull
    private final Safe safe;

    @NotNull
    private final MatrixCalculator matrixCalculator;

    @NotNull
    private final Optimizer optimizer;

    @Autowired
    public Bootstrap(@NotNull Safe safe,
                     @NotNull MatrixCalculator matrixCalculator,
                     @NotNull Optimizer optimizer) {
        this.safe = safe;
        this.matrixCalculator = matrixCalculator;
        this.optimizer = optimizer;
    }

    public List<Item> startOptimize(){
        optimizeSafe();
        return safe.getItems();
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(){
        int[][] matrix = matrixCalculator.calc();
        optimizer.findResult(matrix);
    }

}
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
    private final IAbstractSafeService safeService;

    @NotNull
    private final MatrixCalculator matrixCalculator;

    @NotNull
    private final Optimizer optimizer;

    @Autowired
    public Bootstrap(@NotNull IAbstractSafeService safeService,
                     @NotNull MatrixCalculator matrixCalculator,
                     @NotNull Optimizer optimizer) {
        this.safeService = safeService;
        this.matrixCalculator = matrixCalculator;
        this.optimizer = optimizer;
    }

    public List<Item> startOptimize(){
        optimizeSafe();
        return safeService.getItemsFromSafe();
    }

    /**
     * Методом динамического программирования определяет набор предметов, имеющих наибольшую стоимость, и помещает их в сейф.
     */
    public void optimizeSafe(){
        int[][] matrix = matrixCalculator.calcMatrix();
        optimizer.findResult(matrix);
    }

}
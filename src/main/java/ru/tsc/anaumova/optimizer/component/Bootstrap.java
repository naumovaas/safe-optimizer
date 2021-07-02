package ru.tsc.anaumova.optimizer.component;

import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Component
public class Bootstrap {

    private MatrixCalculator matrixCalculator;

    private Optimizer optimizer;

    public List<Item> startOptimize(final List<Item> items, final Safe safe){
        matrixCalculator = new MatrixCalculator(items, safe);
        optimizer = new Optimizer(items, safe);
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
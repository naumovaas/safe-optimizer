package ru.tsc.anaumova.optimizer.component;

import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@Component
public class Bootstrap {

    public void startOptimize(final List<Item> items, final Safe safe) {
        MatrixCalculator matrixCalculator = new MatrixCalculator(items, safe);
        int[][] matrix = matrixCalculator.calc();
        Optimizer optimizer = new Optimizer(items, safe, matrix);
        optimizer.findResult();
    }

}
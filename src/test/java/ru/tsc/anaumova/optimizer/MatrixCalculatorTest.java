package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.component.MatrixCalculator;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.ArrayList;
import java.util.List;

public class MatrixCalculatorTest {

    @NotNull
    MatrixCalculator matrixCalculator;

    @NotNull
    public List<Item> items = new ArrayList<>();

    @NotNull
    public Safe safe;

    @NotNull
    public int[][] resultMatrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                                    {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 100},
                                    {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 120}};

    @Before
    public void init() {
        items.add(new Item("item - 1", 10, 100));
        items.add(new Item("item - 2", 5, 60));
        items.add(new Item("item - 3", 5, 60));
        safe = new Safe(10);
        matrixCalculator = new MatrixCalculator(items, safe);
    }

    @Test
    public void calcMatrixTest(){
        Assert.assertArrayEquals(resultMatrix, matrixCalculator.calcMatrix());
    }

}

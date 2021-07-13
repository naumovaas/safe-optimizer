package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tsc.anaumova.optimizer.component.Optimizer;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class OptimizerTest {

    @NotNull
    private int[][] matrix;

    private Safe safe;

    @NotNull
    private final List<Item> items = new ArrayList<>();

    @NotNull
    private final List<Item> expectedResult = new ArrayList<>();

    @Autowired
    public void setSafe(@NotNull Safe safe) {
        this.safe = safe;
    }

    @Before
    public void init() {
        items.add(new Item("item - 1", 10, 100));
        items.add(new Item("item - 2", 5, 60));
        items.add(new Item("item - 3", 5, 60));
        expectedResult.add(new Item("item - 2", 5, 60));
        expectedResult.add(new Item("item - 3", 5, 60));
        matrix = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 100},
                {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 120}};
    }

    @Test
    public void findResultTest() {
        Optimizer optimizer = new Optimizer(items, safe);
        optimizer.findResult(matrix);
        List<Item> result = safe.getItems();
        Assert.assertEquals(expectedResult.size(), result.size());
    }

}
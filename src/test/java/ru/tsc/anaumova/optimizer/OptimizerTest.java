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
import ru.tsc.anaumova.optimizer.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class OptimizerTest {

    @NotNull
    private ItemRepository repository;

    @NotNull
    private int[][] matrix;

    private Safe safe;

    @NotNull
    private final List<Item> expectedResult = new ArrayList<>();

    @Autowired
    public void setSafe(@NotNull Safe safe) {
        this.safe = safe;
    }

    @Before
    public void init(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item - 1", 10, 100));
        items.add(new Item("item - 2", 5, 60));
        items.add(new Item("item - 3", 5, 60));
        expectedResult.add(new Item("item - 2", 5, 60));
        expectedResult.add(new Item("item - 3", 5, 60));
        repository = mock(ItemRepository.class);
        when(repository.getAll()).thenReturn(items);
        matrix = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
                {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 100},
                {0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 120}};
    }

    @Test
    public void findResultTest(){
        Optimizer optimizer = new Optimizer(repository.getAll(), safe);
        optimizer.findResult(matrix);
        List<Item> result = safe.getItems();
        Assert.assertEquals(expectedResult.size(), result.size());

    }

}

package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.service.IAbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

public class SafeServiceTest {

    @NotNull
    private Safe safe;

    @NotNull
    private IAbstractSafeService safeService;

    @Before
    public void init() {
        safe = new Safe(10);
        safeService = new SafeService(safe);
    }

    @Test
    public void addItemToSafeTest(){
        Item addedItem = new Item("test-item", 1, 1);
        safeService.addItemToSafe(addedItem);
        Assert.assertNotNull(safe.getItems().get(0));
        Assert.assertEquals(addedItem, safe.getItems().get(0));
        Assert.assertEquals(1, safe.getItems().size());
    }

}

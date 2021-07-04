package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

public class SafeTest {

    @NotNull
    private Safe safe;

    @Before
    public void init() {
        safe = new Safe();
        safe.setCapacity(10);
    }

    @Test
    public void addItemToSafeTest(){
        Item addedItem = new Item("test-item", 1, 1);
        safe.addItemToSafe(addedItem);
        Assert.assertNotNull(safe.getItems().get(0));
        Assert.assertEquals(addedItem, safe.getItems().get(0));
        Assert.assertEquals(1, safe.getItems().size());
    }

    @Test
    public void clearSafeTest(){
        safe.clearSafe();
        Assert.assertEquals(0, safe.getItems().size());
    }

}

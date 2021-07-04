package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class SafeTest {

    private Safe safe;

    @Autowired
    public void setSafe(@NotNull Safe safe) {
        this.safe = safe;
    }

    @Test
    public void addItemToSafeTest(){
        Item addedItem = new Item("test-item", 1, 1);
        safe.addItemToSafe(addedItem);
        Assert.assertNotNull(safe.getItems().get(0));
        Assert.assertEquals(addedItem.getTitle(), safe.getItems().get(0).getTitle());
        Assert.assertEquals(1, safe.getItems().size());
    }

    @Test
    public void clearSafeTest(){
        safe.clearSafe();
        Assert.assertEquals(0, safe.getItems().size());
    }

}

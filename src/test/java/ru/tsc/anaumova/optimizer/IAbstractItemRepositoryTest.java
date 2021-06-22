package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;

public class IAbstractItemRepositoryTest {

    @NotNull
    IAbstractItemRepository repository;

    @Before
    public void init() {
        repository = new ItemRepository("items.json");
    }

    @Test
    public void getAllTest(){
        Assert.assertNotNull(repository.getAll());
    }

}

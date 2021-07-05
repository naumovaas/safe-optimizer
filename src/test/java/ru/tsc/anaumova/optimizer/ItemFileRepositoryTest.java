package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;
import ru.tsc.anaumova.optimizer.repository.ItemFileRepository;

public class ItemFileRepositoryTest {

    @NotNull
    private ItemRepository repository;

    @Before
    public void init() {
        repository = new ItemFileRepository();
    }

    @Test
    public void getAllTest() {
        Assert.assertNotNull(repository.getAll());
    }

}

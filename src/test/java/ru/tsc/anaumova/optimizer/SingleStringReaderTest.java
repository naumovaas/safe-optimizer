package ru.tsc.anaumova.optimizer;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.component.FileReader;
import ru.tsc.anaumova.optimizer.component.SingleStringReader;

public class SingleStringReaderTest {

    @NotNull
    private FileReader readerJSON;

    @Before
    public void init() {
        readerJSON = new SingleStringReader("items.json");
    }

    @Test
    public void readFromJsonTest() {
        String jsonString = readerJSON.readFromFile();
        Assert.assertFalse(jsonString.isEmpty());
    }

}

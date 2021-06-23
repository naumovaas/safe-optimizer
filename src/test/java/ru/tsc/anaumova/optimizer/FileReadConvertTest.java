package ru.tsc.anaumova.optimizer;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.component.ConverterJSON;
import ru.tsc.anaumova.optimizer.component.FileReader;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public class FileReadConvertTest {

    @NotNull
    private FileReader fileReader;

    @NotNull
    private ConverterJSON<Item> converterJSON;

    @Before
    public void init(){
        fileReader = new FileReader("items.json");
        converterJSON = new ConverterJSON<>();
    }

    @Test
    public void readFromJsonTest(){
        String jsonString = fileReader.readJsonFromFile();
        Assert.assertFalse(jsonString.isEmpty());
        Assert.assertTrue(jsonString.contains("item - 1"));
        Assert.assertTrue(jsonString.contains("item - 2"));
        Assert.assertTrue(jsonString.contains("item - 3"));

        List<Item> result = converterJSON.readFromJSON(jsonString, new TypeToken<List<Item>>(){}.getType());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get(0));
        Assert.assertEquals(3, result.size());
    }

}

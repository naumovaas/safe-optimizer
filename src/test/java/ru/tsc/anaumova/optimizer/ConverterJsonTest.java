package ru.tsc.anaumova.optimizer;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.component.ConverterJson;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public class ConverterJsonTest {

    @NotNull
    private ConverterJson<Item> converterJSON;

    private final String jsonString = "[{\"title\": \"item - 1\", \"size\": \"10\", \"cost\": \"100\"}," +
            "{\"title\": \"item - 2\", \"size\": \"5\", \"cost\": \"60\"}," +
            "{\"title\": \"item - 3\", \"size\": \"5\", \"cost\": \"60\"}]";

    @Before
    public void init() {
        converterJSON = new ConverterJson<>();
    }

    @Test
    public void readFromJsonTest() {

        List<Item> result = converterJSON.convertFromJSON(jsonString, new TypeToken<List<Item>>(){}.getType());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get(0));
        Assert.assertEquals(3, result.size());
    }

}

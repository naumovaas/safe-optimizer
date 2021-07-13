package ru.tsc.anaumova.optimizer;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tsc.anaumova.optimizer.component.ConverterJsonToItemList;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public class ConverterJsonToItemListTest {

    @NotNull
    private ConverterJsonToItemList converterJSONToItemList;

    private final String jsonString = "[{\"title\": \"item - 1\", \"size\": \"10\", \"cost\": \"100\"}," +
            "{\"title\": \"item - 2\", \"size\": \"5\", \"cost\": \"60\"}," +
            "{\"title\": \"item - 3\", \"size\": \"5\", \"cost\": \"60\"}]";

    @Before
    public void init() {
        converterJSONToItemList = new ConverterJsonToItemList();
    }

    @Test
    public void readFromJsonTest() {

        List<Item> result = converterJSONToItemList.convertFromJsonToList(jsonString);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get(0));
        Assert.assertEquals(3, result.size());
    }

}

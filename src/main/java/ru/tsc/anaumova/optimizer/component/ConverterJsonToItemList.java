package ru.tsc.anaumova.optimizer.component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.lang.reflect.Type;
import java.util.List;

public class ConverterJsonToItemList implements ConverterJson<Item> {

    private final Type type = new TypeToken<List<Item>>() {}.getType();

    @Override
    public @NotNull List<Item> convertFromJsonToList(@NotNull final String jsonString) {
        final Gson gson = new Gson();
        return gson.fromJson(jsonString, type);
    }

}

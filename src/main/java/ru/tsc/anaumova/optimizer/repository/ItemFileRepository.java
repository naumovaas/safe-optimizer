package ru.tsc.anaumova.optimizer.repository;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.tsc.anaumova.optimizer.component.ConverterJson;
import ru.tsc.anaumova.optimizer.component.FileReader;
import ru.tsc.anaumova.optimizer.component.SingleStringReader;
import ru.tsc.anaumova.optimizer.model.Item;

import java.io.IOException;
import java.util.List;

@Repository
public class ItemFileRepository implements ItemRepository {

    @NotNull
    private final String path = "items.json";

    @Override
    @NotNull
    public List<Item> getAll() throws IOException {
        final FileReader reader = new SingleStringReader(path);
        final ConverterJson<Item> converterJSON = new ConverterJson<>();
        final String jsonString = reader.readFromFile();
        return converterJSON.convertFromJSON(jsonString, new TypeToken<List<Item>>(){}.getType());
    }

}

package ru.tsc.anaumova.optimizer.repository;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.component.ConverterJSON;
import ru.tsc.anaumova.optimizer.component.IFileReader;
import ru.tsc.anaumova.optimizer.component.ReaderJSON;
import ru.tsc.anaumova.optimizer.model.Item;
import java.util.List;

@Component
public class ItemRepository implements IAbstractItemRepository {

    //TODO считывать путь из проперти файла

    @NotNull
    private final String path;

    public ItemRepository(@NotNull String path) {
        this.path = path;
    }

    @Override
    @NotNull
    public List<Item> getAll(){
        final IFileReader readerJSON = new ReaderJSON(path);
        final ConverterJSON<Item> converterJSON = new ConverterJSON<>();
        final String jsonString = readerJSON.readFromFile();
        return converterJSON.convertFromJSON(jsonString, new TypeToken<List<Item>>(){}.getType());
    }

}

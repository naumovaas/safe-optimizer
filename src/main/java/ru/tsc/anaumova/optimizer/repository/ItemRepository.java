package ru.tsc.anaumova.optimizer.repository;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.component.FileReader;
import ru.tsc.anaumova.optimizer.model.Item;
import java.util.List;

public class ItemRepository implements IAbstractItemRepository {

    @NotNull
    private final String path;

    public ItemRepository(@NotNull String path) {
        this.path = path;
    }

    @Override
    @NotNull
    public List<Item> getAll(){
        FileReader<Item> fileReader = new FileReader<>(path);
        return fileReader.readFromJSON(new TypeToken<List<Item>>(){}.getType());
    }

}

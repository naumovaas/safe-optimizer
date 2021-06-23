package ru.tsc.anaumova.optimizer.component;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.List;

public class ConverterJSON<T> {

    @NotNull
    public List<T> readFromJSON(@NotNull final String jsonString, @NotNull Type type){
        final Gson gson = new Gson();
        return gson.fromJson(jsonString, type);
    }

}

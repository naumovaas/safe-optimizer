package ru.tsc.anaumova.optimizer.component;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader<T> {

    @NotNull
    public List<T> readFromJSON(@NotNull final String path, @NotNull Type type){
        final Gson gson = new Gson();
        final String jsonString = readJsonFromFile(path);
        return gson.fromJson(jsonString, type);
    }

    @NotNull
    public String readJsonFromFile(@NotNull final String path){
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return jsonString;
    }

}
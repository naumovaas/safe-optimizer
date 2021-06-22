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
    final String path;

    public FileReader(@NotNull String path) {
        this.path = path;
    }

    @NotNull
    public List<T> readFromJSON(@NotNull Type type){
        final Gson gson = new Gson();
        final String jsonString = readJsonFromFile();
        return gson.fromJson(jsonString, type);
    }

    @NotNull
    public String readJsonFromFile(){
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return jsonString;
    }

}
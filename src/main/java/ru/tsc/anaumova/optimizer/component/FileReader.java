package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    @NotNull
    final String path;

    public FileReader(@NotNull String path) {
        this.path = path;
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
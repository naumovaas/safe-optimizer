package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SingleStringReader implements FileReader {

    @NotNull
    final String path;

    public SingleStringReader(@NotNull String path) {
        this.path = path;
    }

    @Override
    @NotNull
    public String readFromFile() {
        String singleString = "";
        try {
            singleString = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return singleString;
    }

}
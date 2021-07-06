package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface FileReader {

    @NotNull String readFromFile() throws IOException;

}
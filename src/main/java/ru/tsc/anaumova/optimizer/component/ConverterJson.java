package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ConverterJson<T> {

    @NotNull List<T> convertFromJsonToList(@NotNull String jsonString);

}

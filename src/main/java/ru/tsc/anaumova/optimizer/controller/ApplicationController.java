package ru.tsc.anaumova.optimizer.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsc.anaumova.optimizer.component.Bootstrap;
import ru.tsc.anaumova.optimizer.component.ConverterJson;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@RestController
public class ApplicationController {

    @NotNull
    private final Bootstrap bootstrap;

    @NotNull
    private final ConverterJson<Item> converter;

    @Autowired
    public ApplicationController(@NotNull final Bootstrap bootstrap, @NotNull ConverterJson<Item> converter) {
        this.bootstrap = bootstrap;
        this.converter = converter;
    }

    @PostMapping("/get-items")
    Safe getItemsList(@RequestParam int safeCapacity, @RequestParam String itemsString) {
        Safe safe = new Safe(safeCapacity);
        final @NotNull List<Item> items = converter.convertFromJsonToList(itemsString);
        bootstrap.startOptimize(items, safe);
        return safe;
    }

}

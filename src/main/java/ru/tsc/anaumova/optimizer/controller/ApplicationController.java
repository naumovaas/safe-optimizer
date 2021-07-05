package ru.tsc.anaumova.optimizer.controller;

import com.google.gson.reflect.TypeToken;
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

    @Autowired
    public ApplicationController(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @PostMapping("/get-items")
    Safe getItemsList(@RequestParam int safeCapacity, @RequestParam String itemsString) {
        Safe safe = new Safe(safeCapacity);
        final ConverterJson<Item> converterJSON = new ConverterJson<>();
        final List<Item> items = converterJSON.convertFromJSON(itemsString, new TypeToken<List<Item>>(){}.getType());
        bootstrap.startOptimize(items, safe);
        return safe;
    }

}

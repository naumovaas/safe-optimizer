package ru.tsc.anaumova.optimizer.controller;

import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsc.anaumova.optimizer.component.Bootstrap;
import ru.tsc.anaumova.optimizer.component.ConverterJSON;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

@RestController
public class ApplicationController {

    @NotNull
    private final Bootstrap bootstrap;

    @NotNull
    private final Safe safe;

    @Autowired
    public ApplicationController(@NotNull final Bootstrap bootstrap, @NotNull final Safe safe) {
        this.bootstrap = bootstrap;
        this.safe = safe;
    }

    @PostMapping("/get-items")
    Safe getItemsListPOST(@RequestParam int safeCapacity, @RequestParam String itemsString) {
        safe.setCapacity(safeCapacity);
        final ConverterJSON<Item> converterJSON = new ConverterJSON<>();
        final List<Item> items = converterJSON.convertFromJSON(itemsString, new TypeToken<List<Item>>(){}.getType());
        bootstrap.startOptimize(items, safe);
        return safe;
    }

}

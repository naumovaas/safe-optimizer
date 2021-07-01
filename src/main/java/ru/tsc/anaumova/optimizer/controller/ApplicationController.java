package ru.tsc.anaumova.optimizer.controller;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsc.anaumova.optimizer.component.Bootstrap;
import ru.tsc.anaumova.optimizer.model.Safe;

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

    @GetMapping("/get-items")
    String getItemsList(){
        return new Gson().toJson(bootstrap.startOptimize());

        //@PostMapping
        //@RequestParam(value = "safeCapacity") int safeCapacity
        //Safe safe = new Safe(safeCapacity)
        // safe.addOptimizedItems(items)
        //return safe (to JSON)

        //@RequestParam(value = "name") String name


    }

    @PostMapping("/get-items")
    String getItemsListPOST(@RequestParam int safeCapacity) {
        safe.setCapacity(safeCapacity);
        return new Gson().toJson(bootstrap.startOptimize());
    }

}

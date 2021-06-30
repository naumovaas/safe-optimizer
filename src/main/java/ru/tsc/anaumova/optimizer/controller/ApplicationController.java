package ru.tsc.anaumova.optimizer.controller;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsc.anaumova.optimizer.component.Bootstrap;

@RestController
public class ApplicationController {

    @NotNull
    private final Bootstrap bootstrap;

    @Autowired
    public ApplicationController(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @GetMapping("/get-items")
    String getProductsList(){
        return new Gson().toJson(bootstrap.startOptimize());

        //@PostMapping
        //@RequestParam(value = "safeCapacity") int safeCapacity
        //Safe safe = new Safe(safeCapacity)
        // safe.addOptimizedItems(items)
        //return safe (to JSON)


    }

}

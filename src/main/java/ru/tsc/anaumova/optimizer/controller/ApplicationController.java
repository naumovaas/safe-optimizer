package ru.tsc.anaumova.optimizer.controller;

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

    @PostMapping("/get-items")
    Safe getItemsListPOST(@RequestParam int safeCapacity) {
        safe.setCapacity(safeCapacity);
        bootstrap.startOptimize();
        return safe;
    }

}

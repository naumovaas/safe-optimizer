package ru.tsc.anaumova.optimizer.controller;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.tsc.anaumova.optimizer.component.Bootstrap;

@Controller
@RequestMapping("/optimizer")
public class ApplicationController {

    @NotNull
    private final Bootstrap bootstrap;

    @Autowired
    public ApplicationController(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @GetMapping("/get-items")
    @ResponseBody
    String getProductsList(){
        return new Gson().toJson(bootstrap.start());
    }

}
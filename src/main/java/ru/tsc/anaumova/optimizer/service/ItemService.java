package ru.tsc.anaumova.optimizer.service;

import ru.tsc.anaumova.optimizer.model.Item;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    List<Item> getAll() throws IOException;

}
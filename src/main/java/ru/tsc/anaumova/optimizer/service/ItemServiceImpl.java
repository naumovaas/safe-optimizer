package ru.tsc.anaumova.optimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.repository.ItemRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll() throws IOException {
        return itemRepository.getAll();
    }

}

package ru.tsc.anaumova.optimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;

import java.util.List;

@Service
public class ItemService implements IItemService {

    private final IAbstractItemRepository itemRepository;

    @Autowired
    public ItemService(IAbstractItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll(){
        return itemRepository.getAll();
    }

}

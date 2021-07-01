package ru.tsc.anaumova.optimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final IAbstractItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(IAbstractItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll(){
        return itemRepository.getAll();
    }

}

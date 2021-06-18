package ru.tsc.anaumova.optimizer.repository;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public class ItemRepository extends AbstractItemRepository {

    {
        list.add(new Item("item - 1", 10, 100));
        list.add(new Item("item - 2", 5, 60));
        list.add(new Item("item - 3", 5, 60));

//        list.add(new Item("item - 1", 3, 1));
//        list.add(new Item("item - 2", 4, 6));
//        list.add(new Item("item - 3", 5, 4));
//        list.add(new Item("item - 4", 8, 7));
//        list.add(new Item("item - 5", 9, 6));

    }

    @Override
    @NotNull
    public List<Item> getAll(){
        //перед этим прочитать из файла
        return list;
    }

}

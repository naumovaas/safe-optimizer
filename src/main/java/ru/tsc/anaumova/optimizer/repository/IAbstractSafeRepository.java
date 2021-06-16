package ru.tsc.anaumova.optimizer.repository;

import ru.tsc.anaumova.optimizer.model.AbstractItem;
import ru.tsc.anaumova.optimizer.model.AbstractSafe;

import java.util.List;

public interface IAbstractSafeRepository {

    AbstractSafe getSafeById(int id);

}

package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.service.IAbstractSafeService;
import ru.tsc.anaumova.optimizer.service.IItemService;

import java.util.List;

@Component
public class MatrixCalculator {

    @NotNull
    private final List<Item> items;

    private final int itemsCount;

    private final int safeCapacity;

    @Autowired
    public MatrixCalculator(@NotNull IItemService itemService, @NotNull IAbstractSafeService safeService) {
        this.items = itemService.getAll();
        this.itemsCount = items.size();
        this.safeCapacity = safeService.getSafe().getCapacity();
    }

    /**
     * Запускает метод постороения матрицы.
     *
     * @return полученная матрица.
     */
    @NotNull
    public int[][] calcMatrix(){
        return calcMatrix(itemsCount, safeCapacity);
    }

    /**
     * Строит матрицу стоимостей сейфа для разных наборов допустимых предметов.
     *
     * @param itemCount количество предметов.
     * @param maxSafeCapacity вместимость сейфа.
     * @return полученная матрица.
     */
    @NotNull
    private int[][] calcMatrix(final int itemCount, final int maxSafeCapacity){
        int[][] matrix = new int[itemCount + 1][maxSafeCapacity+1];
        for (int i = 1; i <= itemCount; i++)
            for (int safeCapacity = 1; safeCapacity <= maxSafeCapacity; safeCapacity++)
                matrix[i][safeCapacity] = calcElement(matrix, i, safeCapacity);
        return matrix;
    }

    private int calcElement(@NotNull final int[][] matrix, final int i, final int j){
        int result;
        int costSumWithoutCurrentItem = matrix[i - 1][j];
        if (isEnoughSpaceForItem(i, j)) {
            int costSumWithCurrentItem = matrix[i - 1][j - items.get(i-1).getSize()] + items.get(i-1).getCost();
            result = Math.max(costSumWithoutCurrentItem, costSumWithCurrentItem);
        }
        else
            result = costSumWithoutCurrentItem;
        return result;
    }

    private boolean isEnoughSpaceForItem(final int itemIndex, final int safeCapacity){
        return safeCapacity >= items.get(itemIndex-1).getSize();
    }

}
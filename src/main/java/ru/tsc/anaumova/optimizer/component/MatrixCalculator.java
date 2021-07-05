package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

public class MatrixCalculator {

    @NotNull
    private final List<Item> items;

    @NotNull
    private final Safe safe;

    public MatrixCalculator(@NotNull List<Item> items, @NotNull Safe safe) {
        this.items = items;
        this.safe = safe;
    }

    /**
     * Запускает метод постороения матрицы.
     *
     * @return полученная матрица.
     */
    @NotNull
    public int[][] calc() {
        final int maxItemsCount = items.size();
        final int maxSafeCapacity = safe.getCapacity();
        return calc(maxItemsCount, maxSafeCapacity);
    }

    /**
     * Строит матрицу стоимостей сейфа для разных наборов допустимых предметов.
     *
     * @param maxItemsCount   количество предметов.
     * @param maxSafeCapacity вместимость сейфа.
     * @return полученная матрица.
     */
    @NotNull
    private int[][] calc(final int maxItemsCount, final int maxSafeCapacity) {
        int[][] matrix = new int[maxItemsCount + 1][maxSafeCapacity + 1];
        for (int itemsCount = 1; itemsCount <= maxItemsCount; itemsCount++)
            for (int safeCapacity = 1; safeCapacity <= maxSafeCapacity; safeCapacity++)
                matrix[itemsCount][safeCapacity] = calcElement(matrix, itemsCount, safeCapacity);
        return matrix;
    }

    private int calcElement(@NotNull final int[][] matrix, final int i, final int j) {
        int result;
        int costSumWithoutCurrentItem = matrix[i - 1][j];
        if (isEnoughSpaceForItem(i, j)) {
            int costSumWithCurrentItem = matrix[i - 1][j - items.get(i - 1).getSize()] + items.get(i - 1).getCost();
            result = Math.max(costSumWithoutCurrentItem, costSumWithCurrentItem);
        } else
            result = costSumWithoutCurrentItem;
        return result;
    }

    private boolean isEnoughSpaceForItem(final int itemIndex, final int safeCapacity) {
        return safeCapacity >= items.get(itemIndex - 1).getSize();
    }

}
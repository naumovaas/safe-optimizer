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
        final int maxItemNumber = items.size();
        final int maxSafeCapacity = safe.getCapacity();
        return calc(maxItemNumber, maxSafeCapacity);
    }

    /**
     * Строит матрицу стоимостей сейфа для разных наборов допустимых предметов.
     *
     * @param maxItemNumber   количество предметов.
     * @param maxSafeCapacity вместимость сейфа.
     * @return полученная матрица.
     */
    @NotNull
    private int[][] calc(final int maxItemNumber, final int maxSafeCapacity) {
        int[][] matrix = new int[maxItemNumber + 1][maxSafeCapacity + 1];
        for (int itemNumber = 1; itemNumber <= maxItemNumber; itemNumber++) {
            calcSafeCostWithItem(matrix[itemNumber - 1], matrix[itemNumber], itemNumber);
        }
        return matrix;
    }

    private void calcSafeCostWithItem(int[] previousSafeCosts, int[] safeCost, int itemNumber) {
        final int maxSafeCapacity = safe.getCapacity();
        for (int safeCapacity = 1; safeCapacity <= maxSafeCapacity; safeCapacity++) {
            safeCost[safeCapacity] = calcElement(previousSafeCosts, itemNumber, safeCapacity);
        }
    }

    private int calcElement(@NotNull final int[] safeCostForPreviousItem , final int i, final int j) {
        int result;
        int costSumWithoutCurrentItem = safeCostForPreviousItem[j];
        if (isItemSizeLessThenSafeCapacity(i, j)) {
            int costSumWithCurrentItem = safeCostForPreviousItem[j - items.get(i - 1).getSize()] + items.get(i - 1).getCost();
            result = Math.max(costSumWithoutCurrentItem, costSumWithCurrentItem);
        } else {
            result = costSumWithoutCurrentItem;
        }
        return result;
    }

    private boolean isItemSizeLessThenSafeCapacity(final int itemIndex, final int safeCapacity) {
        return safeCapacity >= items.get(itemIndex - 1).getSize();
    }

}
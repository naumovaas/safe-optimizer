package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

public class MatrixCalculator {

    @NotNull
    private final List<Item> items;

    private final int itemsCount;

    private final int safeCapacity;

    public MatrixCalculator(@NotNull List<Item> items, @NotNull Safe safe) {
        this.items = items;
        this.itemsCount = items.size();
        this.safeCapacity = safe.getCapacity();
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
     * @param safeCapacity вместимость сейфа.
     * @return полученная матрица.
     */
    @NotNull
    private int[][] calcMatrix(final int itemCount, final int safeCapacity){
        int[][] array = new int[itemCount + 1][safeCapacity+1];
        for (int i = 1; i <= itemCount; i++)
            for (int j = 1; j <= safeCapacity; j++) {
                if (j < items.get(i-1).getSize())
                    array[i][j] = array[i - 1][j];
                else
                    array[i][j] = Math.max(array[i - 1][j], array[i - 1][j - items.get(i-1).getSize()] + items.get(i-1).getCost());
            }
        return array;
    }

}

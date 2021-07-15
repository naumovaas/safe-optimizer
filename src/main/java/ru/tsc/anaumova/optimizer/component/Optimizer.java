package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;

import java.util.List;

public class Optimizer {

    @NotNull
    private final List<Item> items;

    @NotNull
    private final Safe safe;

    @NotNull
    private final int[][] matrix;

    public Optimizer(@NotNull List<Item> items, @NotNull Safe safe, @NotNull int[][] matrix) {
        this.items = items;
        this.safe = safe;
        this.matrix = matrix;
    }

    /**
     * Для переданой матрицы запускает метод определения предметов, составляющих оптимальное решение.
     *
     */
    public void findResult() {
        findResult(getItemsCount(), getSafeCapacity());
    }

    /**
     * Восстанавливает путь от наибольшего значения в матрице к началу.
     * Соответствующие предметы кладем в сейф.
     *
     * @param i      индекс наибольшего значения на данном этапе.
     * @param j      индекс наибольшего значения на данном этапе.
     */
    private void findResult(int i, int j) {
        while (matrix[i][j] != 0) {
            if (isItemAddToSafe(matrix, i, j)) {
                j = j - items.get(i - 1).getSize();
                safe.addItemToSafe(items.get(i - 1));
            }
            i--;
        }
    }

    private boolean isItemAddToSafe(@NotNull final int[][] matrix, int i, int j) {
        return matrix[i][j] != matrix[i - 1][j];
    }

    private int getItemsCount() {
        return items.size();
    }

    private int getSafeCapacity() {
        return safe.getCapacity();
    }

}
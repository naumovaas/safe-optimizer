package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;
import ru.tsc.anaumova.optimizer.model.Safe;
import ru.tsc.anaumova.optimizer.repository.IAbstractItemRepository;
import ru.tsc.anaumova.optimizer.service.IAbstractSafeService;
import ru.tsc.anaumova.optimizer.service.SafeService;

import java.util.List;

public class Optimizer {

    @NotNull
    private final List<Item> items;

    @NotNull
    private final IAbstractSafeService safeService;

    @NotNull
    private final Safe safe;

    public Optimizer(@NotNull final List<Item> items, @NotNull Safe safe) {
        this.safe = safe;
        this.items = items;
        this.safeService = new SafeService(safe);
    }

    /**
     * Для переданой матрицы запускает метод определения предметов, составляющих оптимальное решение.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     */
    public void findResult(@NotNull final int[][] matrix){
        findResult(matrix, getItemsCount(), getSafeCapacity());
    }

    /**
     * Восстанавливает путь от наибольшего значения в матрице к началу.
     * Соответствующие предметы кладем в сейф.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     * @param i индекс наибольшего значения на данном этапе.
     * @param j индекс наибольшего значения на данном этапе.
     */
    private void findResult(@NotNull final int[][] matrix, int i, int j) {
        while (matrix[i][j] != 0) {
            if (isItemAddToSafe(matrix, i, j)) {
                j -= items.get(i - 1).getSize();
                safeService.addItemToSafe(items.get(i - 1));
            }
            i --;
        }
    }

    private boolean isItemAddToSafe(@NotNull final int[][] matrix, int i, int j){
        return matrix[i][j] != matrix[i - 1][j];
    }

    private int getItemsCount(){
        return items.size();
    }

    private int getSafeCapacity(){
        return safe.getCapacity();
    }

}
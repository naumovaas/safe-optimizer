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

    public Optimizer(@NotNull IAbstractItemRepository itemRepository, @NotNull Safe safe) {
        items = itemRepository.getAll();
        safeService = new SafeService(safe);
    }

    /**
     * Для переданой матрицы запускает метод определения предметов, составляющих оптимальное решение.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     */
    public void findResult(@NotNull final int[][] matrix){
        findResult(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    /**
     * Восстанавливаем путь от наибольшего значения в матрице к началу.
     * Соответствующие предметы кладем в сейф.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     * @param i индекс наибольшего значения на данном этапе.
     * @param j индекс наибольшего значения на данном этапе.
     */
    private void findResult(@NotNull final int[][] matrix, int i, int j) {
        while (matrix[i][j] != 0) {
            if (matrix[i][j] != matrix[i - 1][j]) {
                j -= items.get(i - 1).getSize();
                safeService.addItemToSafe(items.get(i - 1));
            }
            i --;
        }
    }

    /**
     * Строим матрицу стоимостей сейфа для разных наборов допустимых предметов.
     *
     * @return полученная матрица.
     */
    public int[][] calcMatrix(final int safeCapacity){
        final int itemCount = items.size();
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
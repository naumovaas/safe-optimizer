package ru.tsc.anaumova.optimizer.component;

import org.jetbrains.annotations.NotNull;
import ru.tsc.anaumova.optimizer.model.Item;

import java.util.List;

public class Optimizer {

    /**
     * Для переданой матрицы запускает метод определения предметов, составляющих оптимальное решение.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     */
    public static void findResult(@NotNull final int[][] matrix){
        findResult(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    /**
     * Рекурсивно восстанавливаем путь от наибольшего значения в матрице к началу.
     * Соответствующие предметы кладем в сейф.
     *
     * @param matrix матрица стоимостей разных наборов допустимых предметов.
     * @param i индекс наибольшего значения на данном этапе.
     * @param j индекс наибольшего значения на данном этапе.
     */
    private static void findResult(@NotNull final int[][] matrix, final int i, final int j){
        if(matrix[i][j] == 0) return;
        if (matrix[i][j] == matrix[i - 1][j])
            findResult(matrix, i-1, j);
        else {
            findResult(matrix, i - 1, j - Bootstrap.getItems().get(i - 1).getSize());
            Bootstrap.getSafeService().addItemToSafe(Bootstrap.getItems().get(i - 1));
        }
    }

    /**
     * Строим матрицу стоимостей сейфа для разных наборов допустимых предметов.
     *
     * @return полученная матрица.
     */
    public static int[][] calcMatrix(){
        final int safeCapacity = Bootstrap.getSafe().getCapacity();
        final List<Item> items = Bootstrap.getItems();
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
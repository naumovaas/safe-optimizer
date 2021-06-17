package ru.tsc.anaumova.optimizer.component;

import ru.tsc.anaumova.optimizer.model.AbstractItem;

import java.util.List;

public class Optimizer {

    public static void findResult(final int[][] matrix){
        int i = matrix.length - 1;
        int j = matrix[0].length - 1;
        findResult(matrix, i, j);
    }

    public static void findResult(final int[][] matrix, final int i, final int j){
        if(matrix[i][j] == 0) return;
        if (matrix[i][j] == matrix[i - 1][j])
            findResult(matrix, i-1, j);
        else {
            findResult(matrix, i - 1, j - Bootstrap.getItems().get(i - 1).getSize());
            Bootstrap.getSafeService().addItemToSafe(Bootstrap.getItems().get(i - 1));
        }
    }

    public static int[][] calcMatrix(final List<AbstractItem> items, final int safeCapacity){
        final int itemCount = items.size();
        int[][] array = new int[itemCount + 1][safeCapacity+1];
        for (int i = 1; i <= itemCount; i++)
            for (int j = 1; j <= safeCapacity; j++) {
                if (j < items.get(i-1).getSize())
                    array[i][j] = array[i - 1][j];
                else
                    array[i][j] = Math.max(array[i - 1][j], array[i - 1][j - items.get(i-1).getSize()] + items.get(i-1).getCost());
            }

        for (int i = 0; i <= itemCount; i++) {
            for (int j = 0; j <= safeCapacity; j++)
                System.out.printf("%4d", array[i][j]);
            System.out.println();
        }
        return array;
    }

}
package com.algo.dp;

/**
 * Created by vaibhavhajela on 16/10/20.
 */
public class TablePrinter {

    public static void printMatrix(int size, int row, int[][] matrix) {
        clearScreen();

        for (int i = 0; i < 7 * matrix[row].length; i++) {
            System.out.print("-");
        }
        System.out.println("-");

        for (int i = 1; i <= matrix[row].length; i++) {
            System.out.printf("| %4d ", matrix[row][i - 1]);
        }
        System.out.println("|");

        if (row == size - 1) {

            // when we reach the last row,
            // print bottom line "---------"

            for (int i = 0; i < 7 * matrix[row].length; i++) {
                System.out.print("-");
            }
            System.out.println("-");

        }
        System.out.println();
        System.out.println();


    }

    public static void printTable(int[][] matrix) {

        int rowsLength = matrix.length;

        for (int k = 0; k < rowsLength; k++) {

            printMatrix(rowsLength, k, matrix);

        }

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printArray(int[][] array) {
        clearScreen();
        System.out.print(" ");
        for (int row = 0; row < array[0].length; row++) {
            System.out.print("  " + row);
        }
        System.out.println();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (col < 1) {
                    System.out.print(row);
                    System.out.print("  " + array[row][col]);
                } else {

                    System.out.print("  " + array[row][col]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
package L3;
import java.io.*;

import java.awt.image.renderable.ParameterBlock;
import java.security.PublicKey;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] dataMatrix;


    // онструктор матрицы с параметрами
    public Matrix(int[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.dataMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.dataMatrix[i][j] = data[i][j];
            }
        }
    }

    // онструктор матрицы без параметров
    public Matrix() {
        this.rows = 3;
        this.columns = 3;
        this.dataMatrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    }

    //ћетод выведени€ матриц 2 на 2
    public void twoByTwoMatrix() {
        if (rows >= 2 && rows < 5 && columns >= 2 && columns < 5) {
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < columns - 1; j++) {
                    System.out.println(dataMatrix[i][j] + " " + dataMatrix[i][j + 1]);
                    System.out.println(dataMatrix[i + 1][j] + " " + dataMatrix[i + 1][j + 1]);
                    System.out.println();
                }
            }

        } else {
            System.out.println("ћатрица не поход€щего формата");
        }
    }

    //ћетод дл€ подсчета количества матриц 2 на 2
    public void numberOfMatrixTwoByTwo() {
        int quantity = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                quantity += 1;
            }
        }
        System.out.println("ћатрица содержит " + quantity + " матриц два на два");
    }

    //ћетод дл€ определени€ упор€доченности элементов главной диагонали по возрастанию
    public void certaintyOfOrder() {
        boolean flag = true;
        if (rows == columns) {
            for (int i = 0; i < rows - 1; i++) {
                if (dataMatrix[i][i] > dataMatrix[i + 1][i + 1]) {
                    System.out.println("Ёлементы не упор€дочены");
                    flag = false;
                    break;
                }

            }
            if (flag == true) {
                System.out.println("Ёлементы упор€дочены");
            }
        } else {
            System.out.println("ћатрица не квадратна€");
        }
    }

    //ћетод дл€ выведени€ матрицы спиралью
    public void spiral() {
        int first_row = 0;
        int first_column = 0;
        int last_row = rows - 1;
        int last_column = columns - 1;

        while (last_row - first_row >= 0 && last_column - first_column >= 0) {
            for (int i = last_column; i >= first_column; i--) {
                System.out.println(dataMatrix[last_row][i]);

            }
            last_row -= 1;

            if (last_row - first_row >= 0 && last_column - first_column >= 0) {
                for (int i = last_row; i >= first_row; i--) {
                    System.out.println(dataMatrix[i][first_column]);
                }
                first_column += 1;
            }


            if (last_row - first_row >= 0 && last_column - first_column >= 0) {
                for (int i = first_column; i <= last_column; i++) {
                    System.out.println(dataMatrix[first_row][i]);
                }
                first_row += 1;
            }

            if (last_row - first_row >= 0 && last_column - first_column >= 0) {
                for (int i = first_row; i <= last_row; i++) {
                    System.out.println(dataMatrix[i][last_column]);
                }
                last_column -= 1;
            }
        }
    }
}






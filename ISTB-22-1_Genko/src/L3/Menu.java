package L3;

import java.util.Scanner;
import java.io.*;


public class Menu {
    private static Matrix matrix;
    private static Text text;
    private static int[][] completed_matrix;
    private static String completed_str;
    private static Scanner in = new Scanner(System.in);

    //����� ��� ������ �������� ����
    public static void start() {
        {
            int choice = -1;
            do {
                System.out.println("�������� � ��� �� ������ ��������[�������(1)/������(2)/�����(0)]");
                try {
                    choice = readInt(0, 2);
                    switch (choice) {
                        case 1:
                            enterValueMatrix();
                            workingWithMatrix();
                            saveMatrix();
                            break;
                        case 2:
                            enterValueString();
                            workingWithString();
                            saveString();
                            break;
                        case 0:
                            System.out.println("��������� ���������");
                            break;
                        default:
                            System.out.println("�������� ��������");

                    }

                } catch (NumberFormatException e) {
                    System.out.println("������ �����. ����������, ������� �����.");
                }
            }
            while (choice != 0);
        }
    }

    //����� ��� ������ ������� ����� �������
    public static void enterValueMatrix() {
        System.out.println("�������� ������ ����� �������[�������(1)/����(2)/������(3)]");
        int choice = readInt(1, 3);
        switch (choice) {
            case 1:
                matrixInputConsole();
                break;
            case 2:
                matrixInputFile();
                break;
            case 3:
                matrixInputExample();
                break;
        }


    }

    //����� ���������� ��������� � ������� ����� �������
    public static void matrixInputConsole() {
        System.out.println("���������� �����");
        int rows = readInt(1, Integer.MAX_VALUE);

        System.out.println("���������� ��������");
        int columns = readInt(1, Integer.MAX_VALUE);
        int[][] data = new int[rows][columns];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Matrix " + i + j + " = ");
                data[i][j] = readInt(1, Integer.MAX_VALUE);
            }
        }
        matrix = new Matrix(data);
        completed_matrix = data;
    }

    //����� ��� ����� ����� ��� ������
    public static int readInt(int minValue, int maxValue) {
        int error = 0;
        int value = 0;
        do {
            error = 0;
            try {
                value = Integer.parseInt(in.nextLine());
                if (value < minValue || value > maxValue) {
                    System.out.println("������� �� ��������� �� " + minValue + " �� " + maxValue);
                    error = 1;
                }
            } catch (NumberFormatException ex) {
                error = 1;
                System.out.println("������������ ������, ������� �����");
            }

        } while (error != 0);
        return value;
    }

    //����� ����� ������ ��� ������
    public static String readStr() {
        int error = 0;
        String value_str = "";
        int[] numbers = new int[0];
        do {
            error = 0;
            try {
                value_str = in.nextLine();
                String[] check = value_str.split(" ");
                numbers = new int[check.length];
                for (int i = 0; i < check.length; i++) {
                    numbers[i] = Integer.parseInt(check[i]);
                }
            } catch (NumberFormatException ex) {
                error = 1;
                System.out.println("������������ ������, ������� �����");
            }
        } while (error != 0);
        return value_str;
    }


    //����� ���������� ��������� � ������� �� �����
    public static void matrixInputFile() {
        String fileName = "E:\\ISTB-22-1_Genko\\matrix.txt";
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            int rows = 0;
            int columns = 0;
            int i = 0;
            int j = 0;
            int[][] data = null;
            boolean r = true;
            boolean c = false;

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (r) {
                    rows = number;
                    r = false;
                    c = true;
                } else if (c) {
                    columns = number;
                    c = false;
                    data = new int[rows][columns];
                } else {
                    data[i][j] = number;
                    j++;
                    if (j == rows) {
                        i++;
                        j = 0;
                    }
                }
            }
            matrix = new Matrix(data);
            completed_matrix = data;

        } catch (FileNotFoundException e) {
            System.out.println("������ ������ ����� " + fileName);
            System.out.println("�������� ������ ����� �������[�������(1)/������(2)]");
            int choice = readInt(1, 2);

            switch (choice) {
                case 1:
                    matrixInputConsole();
                    break;
                case 2:
                    matrixInputExample();
                    break;
            }
        }
    }

    //����� ���������� ��������� � ������� �� �������
    public static void matrixInputExample() {
        int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new Matrix(data);
        completed_matrix = data;
    }

    //����� ��� ������ ������� ����� ������
    public static void enterValueString() {
        System.out.println("�������� ������ ����� ������[�������(1)/����(2)/������(3)]");
        int choice = readInt(1, 3);

        switch (choice) {
            case 1:
                stringInputConsole();
                break;
            case 2:
                stringInputFile();
                break;
            case 3:
                stringInputExample();
                break;
        }
    }


    //����� ���������� ��������� � ������ ����� �������
    public static void stringInputConsole() {
        System.out.print("������� ������: ");
        String str = readStr();
        System.out.println("������� ����� ��� �������� ���������");
        int number = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        text = new Text(str, number);
        completed_str = str;
    }

    //����� ���������� ��������� � ������ �� �����
    public static void stringInputFile() {
        String str = "";
        try (FileReader reader = new FileReader("E:\\ISTB-22-1_Genko\\text.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                str += (char) c;
            }
        } catch (IOException ex) {
            System.out.println("������ ������ �����");
            System.out.println("�������� ������ ����� ������[�������(1)/������(2)]");
            int choice = readInt(1, 2);
            switch (choice) {
                case 1:
                    stringInputConsole();
                    break;
                case 2:
                    stringInputExample();
                    break;
            }
        }
        System.out.println("������� ����� ��� �������� ���������");
        int number = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        text = new Text(str, number);
        completed_str = str;
    }

    //����� ���������� ��������� � ������ �� �������
    public static void stringInputExample() {
        String str = "11 22 33 44 55 66 77 88 99";
        System.out.println("������� ����� ��� �������� ���������");
        int number = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        text = new Text(str, number);
        completed_str = str;
    }

    //����� ��� ������ �������� � ��������
    public static void workingWithMatrix() {
        System.out.println("�������� �������� � ��������[������� ��� �� ���(1)/���������� ������ ��� �� ���(2)/��������������� ������� ���������(3)/����� ��������(4)]");
        int choice = readInt(1, 4);
        switch (choice) {
            case 1:
                matrix.twoByTwoMatrix();
                break;
            case 2:
                matrix.numberOfMatrixTwoByTwo();
                break;
            case 3:
                matrix.certaintyOfOrder();
                break;
            case 4:
                matrix.spiral();
                break;
        }
    }

    //����� ��� ������ �������� �� �������
    public static void workingWithString() {
        System.out.println("�������� �������� �� �������[���������� ������� �����(1)]");
        int choice = readInt(1, 1);
        switch (choice) {
            case 1:
                text.numberOfMultiples();
                break;
        }
    }

    //����� ��� ������ ������� ������ �������
    public static void saveMatrix() {
        System.out.println("�������� ������ ������ �������[�������(1)/����(2)]");
        int choice = readInt(1, 2);
        switch (choice) {
            case 1:
                printMatrix();
                break;
            case 2:
                saveMatrixFile();
                break;
        }
    }

    //����� ��� ������ ������� ������ ������
    public static void saveString() {
        System.out.println("�������� ������ ������ ������[�������(1)/����(2)]");
        int choice = readInt(1, 2);
        switch (choice) {
            case 1:
                printText();
                break;
            case 2:
                saveTextFile();
                break;
        }
    }

    //����� ��� ��������� ������� � �������
    public static void printMatrix() {
        for (int i = 0; i < completed_matrix.length; i++) {
            for (int j = 0; j < completed_matrix[i].length; j++) {
                System.out.print(" " + completed_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //����� ��� ���������� ������� � ����
    public static void saveMatrixFile() {
        try (FileWriter writer = new FileWriter("E:\\ISTB-22-1_Genko\\matrix.txt", false)) {
            String m = completed_matrix.length + " " + completed_matrix[0].length + " ";
            for (int i = 0; i < completed_matrix.length; i++) {
                for (int j = 0; j < completed_matrix[i].length; j++) {
                    m += completed_matrix[i][j] + " ";
                }
            }
            writer.write(m);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //����� ��� ��������� ������ � �������
    public static void printText() {
        System.out.println(completed_str);
    }

    //����� ��� ���������� ������ � ����
    public static void saveTextFile() {
        try (FileWriter writer = new FileWriter("E:\\ISTB-22-1_Genko\\text.txt", false)) {
            String t = completed_str;
            writer.write(t);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


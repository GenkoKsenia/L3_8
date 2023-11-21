package L3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Text {
    private String str;
    private int number;

    //Конструктор строки с парматерами
    public Text(String input, int num) {

        this.str = input;
        this.number = num;
    }

    //Конструктор строки без параметров
    public Text() {
        str = " ";
    }

    //Метод для определения количества чисел кратных введенному числу
    public void numberOfMultiples() {
        int k = 0;
        String[] nstr = str.split(" ");
        int[] numbers = new int[nstr.length];
        for (int i = 0; i < nstr.length; i++) {
            numbers[i] = Integer.parseInt(nstr[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % number == 0) {
                k += 1;
            }

        }
        System.out.println("Строка содержит " + k + " чисел, кратных " + number);
    }
}

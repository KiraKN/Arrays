package com.kirakn.arrays;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // поля
    // строка для анализа
    private String pi = "3.141592653589793238462643383279502884197169399375105820974944\n" +
            "592307816406286208998628034825342117067982148086513282306647\n" +
            "093844609550582231725359408128481117450284102701938521105559\n" +
            "644622948954930381964428810975665933446128475648233786783165";

    private int[] arrayInt; // массив для цифр заданного числа
    private int volume3; // количество цифр 3
    private int volume5; // количество цифр 5
    private int unpopularDigit; // самая частая цифра
    private int[] reversArrayInt; // массив задом наперёд
    private String  reversStringInt; // массив задом наперёд в виде строки
    private int[] sortArrayInt; // отсортированный массив

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация полей
        arrayInt = arrayInt(pi);
        volume3 = volume3(arrayInt);
        volume5 = volume5(arrayInt);
        unpopularDigit = unpopularDigit(arrayInt);
        reversArrayInt = reversArrayInt(arrayInt);

        reversStringInt = Arrays.toString(reversArrayInt); // преобразование массива в строку

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length); // копирование массива
        Arrays.sort(sortArrayInt); // сортировка массива

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("Массив из строки " + Arrays.toString(arrayInt) + "\n"
                + "Количество цифр 3 " + volume3 + "\n"
                + "Количество цифр 5 " + volume5 + "\n"
                + "Самая не часто встречающаяся цифра " + unpopularDigit + "\n"
                + "Отсортированный массив " + Arrays.toString(sortArrayInt));
    }

    // метод определения массива задом наперёд
    private int[] reversArrayInt(int[] arrayDigit) {
        int[] revers = new int[arrayDigit.length]; // задание нового массива
        for (int i = arrayDigit.length - 1; i >= 0; i--) { // перебор входного массива
            revers[arrayDigit.length - (i + 1)] = arrayDigit[i]; // инициализация задом наперёд
        }
        return revers;
    }


    private int unpopularDigit(int[] arrayDigit) {
        int[] count = new int[10]; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            switch (i) { // заполнение счётчиков
                case 0: count[0]++; break;
                case 1: count[1]++; break;
                case 2: count[2]++; break;
                case 3: count[3]++; break;
                case 4: count[4]++; break;
                case 5: count[5]++; break;
                case 6: count[6]++; break;
                case 7: count[7]++; break;
                case 8: count[8]++; break;
                case 9: count[9]++; break;
            }
        }
        int unpopular = 0; // задание параметра
        for (int i = 0; i < count.length; i++) { // перебор массива счётчика
            if (count[i] < count[unpopular]) unpopular = i;
        }
        return unpopular;
    }

    // метод определения количества цифр 3
    private int volume3(int[] arrayDigit) {
        int count = 0; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            if (i == 3) {
                count++;
            }
        }
        return count;
    }
    private int volume5(int[] arrayDigit) {
        int count = 0; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            if (i == 5) {
                count++;
            }
        }
        return count;
    }

    // метод получения массива заданного числа
    private int[] arrayInt(String string) {
        String stringNew = string.replace(".", "");
        String[] arrayString = stringNew.split("");
        List<Integer> list = new ArrayList<>();
        for (String s : arrayString) {
            if (Character.isDigit(s.charAt(0))) { // проверка, является ли символ числом
                list.add(Integer.parseInt(s));
            }
        }
        int[] arrayInteger = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrayInteger[i] = list.get(i);
        }
        return arrayInteger;
    }

}
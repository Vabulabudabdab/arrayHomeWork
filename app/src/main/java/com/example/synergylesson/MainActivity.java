package com.example.synergylesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String exponent = "3,1415926536";
    private int[] arrayInt;
    private int volume3and5;
    private int rareDigit;
    private int sumDigit;
    private int[] reverseArrayInt;
    private String reverseStringInt;
    private int[] sortArrayInt;
    private TextView infoApp; // TF op string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init fields
        arrayInt = arrayInt(exponent);
        volume3and5 = volume3and5(arrayInt);
        rareDigit = rareDigit(arrayInt);
        sumDigit = sumDigit(arrayInt);
        reverseArrayInt = reverseArrayInt(arrayInt);

        reverseStringInt = Arrays.toString(reverseArrayInt);

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length);
        Arrays.sort(sortArrayInt);

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Количество цифр 3 и 5" + volume3and5 + "\n"
                + "Массив" + Arrays.toString(arrayInt) + "\n"
                + "Самая редкая цифра" + rareDigit + "\n"
                + "Отсортированный массив  в обратном порядке" + reverseStringInt);
    }

    private int[] reverseArrayInt(int[] arrayDigit) {
        int[] reverse = new int[arrayDigit.length]; //new arr
        for(int i = arrayDigit.length - 1; i >= 0; i--) {
            reverse[arrayDigit.length - (i + 1)] = arrayDigit[i]; //init
        }
        return reverse;
    }

    private int sumDigit(int[] arrayDigit) {
        int sum = 0;
        for (int i: arrayDigit) {
            sum += i;
        }
        return sum;
    }

    private int rareDigit(int[] arrayDigit) {
        int[] count = new int[10];
        for(int i : arrayDigit) {
            switch (i) {
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

        int popular = 0;

        for (int i = 0; i < count.length; i++) {
            if(count[i] < count[popular]) popular = i;
        }
        return popular;
    }

    private int volume3and5(int[] arrayDigit) {
        int count = 0;
        for(int i: arrayDigit) {
            if (i == 3 || i == 5) {
                count++;
            }
        }
        return count;
    }

    private int[] arrayInt(String string) {
        String stringNew = string.replace(".", "");
        String[] arrayString = stringNew.split("");
        int[] arrayInteger = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }













}
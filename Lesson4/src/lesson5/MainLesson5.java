package lesson5;

import java.util.Arrays;

public class MainLesson5 {
    static final int SIZE = 10000000;
    static final int HALFSIZE = SIZE/2;
    public static void main(String[] args) {
        long time;

        //первое прохождение
        float[] arr = new float[SIZE];
        Arrays.fill(arr,1);
        time = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.print("Время первого прохождения по массиву ");
        System.out.println(System.currentTimeMillis()-time);

        //переназначение массива
        Arrays.fill(arr,1);

        //второе прохождение
        time = System.currentTimeMillis();
        float[] arr1 = new float[HALFSIZE];
        float[] arr2 = new float[HALFSIZE];
        System.arraycopy(arr, 0, arr1, 0, HALFSIZE);
        System.arraycopy(arr, HALFSIZE, arr2,0, HALFSIZE);
        new Thread(() -> {
            for (int i = 0; i < HALFSIZE; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();
        for (int i = HALFSIZE; i < SIZE; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(arr1, 0, arr, 0, HALFSIZE);
        System.arraycopy(arr2, 0, arr, HALFSIZE, HALFSIZE);
        System.out.print("Время второго прохождения по массиву ");
        System.out.println(System.currentTimeMillis()-time);
    }
}

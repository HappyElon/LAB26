package ru.mirea.LAB26.task1;

import java.util.Stack;

public class ArrayInverter {
    public static void invertArray(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int value : array) {
            stack.push(value);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};

        System.out.println("Basic array:");
        printArray(originalArray);

        invertArray(originalArray);

        System.out.println("\nInverted array:");
        printArray(originalArray);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}


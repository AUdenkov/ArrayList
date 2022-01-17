package com.company;

import java.util.Arrays;

public class ArrayListed<T> {
    private T[] list;
    private int size;
    private int capacity=10;

    public ArrayListed() {
        list = (T[]) new Object[capacity];
    }

    public ArrayListed(int capacity) {
        list = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void add(T elem) {
        if (size==capacity-1){
            list=increase(list);
        }
        System.out.println(capacity);
        list[size++] = elem;
    }

    public void add(int index, T elem) {
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = elem;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];

        }
    }

    public void print() {
        for (T elem : list) {
            System.out.print(elem + ",");
        }

    }

    private T[] increase(T[] array) {
        capacity= (int) (capacity*1.5);
        T [] newArray= (T[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i]=array[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list,size));
    }
}

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class PhanTu <T> {
    private T[] a;
    private int length;

    public PhanTu() {
        a = (T[]) new Object[1];
        length = 0;
    }

    private void reSize(int newLength) {
        T[] newIteam = (T[]) new Object[newLength];
        for (int i = 0; i < length; i++) {
            newIteam[i] = a[i];
        }
        a = newIteam;
    }

    public void insertItem(T add) {
        if (length == a.length) {
            reSize(a.length * 2);
        }
        a[length++] = add;
    }

    public abstract boolean greaterThan(T a, T b);

    public void insertionSort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j > 0; j--){
                if (greaterThan(a[j - 1], a[j])) {
                    T temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public T[] toArr() {
        T[] res = (T[]) new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }
        return res;
    }
}


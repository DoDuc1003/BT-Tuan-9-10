

import java.util.ArrayList;
import java.util.List;

public class PhanTu <T extends Comparable<T>> {
    public List<T> a;

    public PhanTu() {
        a = new ArrayList<T>();
    }

    public void setAll(List<T> t) {
        a = t;
    }

    public void insertItem(T add) {
        a.add(add);
        System.out.println("done");
    }

    public void print() {
        for (T t : a) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public T getValue(int index) {
        return a.get(index);
    }



    public int size() {
        return a.size();
    }

    public List<T> toArr() {
        return a;
    }
}


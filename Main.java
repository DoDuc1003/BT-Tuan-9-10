
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
public class Main {
    static PhanTu<Integer> pt = new PhanTu<>();
    static int[] a = new int[100];
    public static void readFromFile(String pathInputFile, PhanTu<Integer> pt) {
        Path path = Path.of(pathInputFile);
        try {
            List<String> list = Files.readAllLines(path);
            String[] x = list.get(0).split(" ");
            for (int i = 0; i < x.length; i++) {
                a[i] = Integer.valueOf(x[i]);
                pt.insertItem(a[i]);
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String pathOutputFile, PhanTu<Integer> pt) {
        try {
            FileWriter write = new FileWriter(pathOutputFile);
            for (int i = 0; i < pt.size(); i++) {
                write.write(pt.getValue(i) + " ");
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertionSort(PhanTu<Integer> pt) {
        List<Integer> a = pt.toArr();
        Collections.sort(a);
        pt.setAll(a);
    }

    public static void main(String[] args) {

        readFromFile(args[0], pt);
        /*pt.insertItem(3);
        pt.insertItem(5);
        pt.insertItem(2);
        pt.insertItem(1);
        pt.insertItem(4);*/
        pt.print();
        insertionSort(pt);
        pt.print();
        writeToFile(args[1], pt);

    }

}

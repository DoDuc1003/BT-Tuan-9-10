package com.company;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
public class Main {


    public static void readFromFile(String pathInputFile, PhanTu<Integer> pt) {
        Path path = Path.of(pathInputFile);
        try {
            List<String> list = Files.readAllLines(path);
            for (String element : list) {
                pt.insertItem(Integer.valueOf(element));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String pathOutputFile, PhanTu<Integer> pt) {
        try {
            FileWriter write = new FileWriter(pathOutputFile);
            Integer[] X = pt.toArr();
            for (int i : X) {
                write.write(i + '\n');
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PhanTu<Integer> pt = new PhanTu<Integer>() {
            @Override
            public boolean greaterThan(Integer a, Integer b) {
                if (a > b) {
                    return true;
                }
                return false;
            }
        };
        readFromFile(args[0], pt);
        pt.insertionSort();
        writeToFile(args[0], pt);



    }

}

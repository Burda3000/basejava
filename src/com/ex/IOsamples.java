package com.ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IOsamples {
    public static void main(String[] args) {
        byte[] bytesToWrite = {1, 2, 3};
        byte[] bytesReaded = new byte[10];
//        String fileName = "/home/aleksandr/документы";
        File file = new File("/home/aleksandr/документы");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
//            file.

//            fileInputStream.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
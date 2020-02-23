package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);

        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("C:\\Users\\Ashcr\\Desktop\\TopJava\\basejava\\src\\com\\urise\\webapp");
        System.out.println(dir.isDirectory());

        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getFiles(dir);
    }

    private static void getFiles(File searchDir) {
        File[] file = searchDir.listFiles();
        if (file != null) {
            for (File name : file) {
                if (name.isFile()) {
                    System.out.println("    " + name.getName());
                } else if (name.isDirectory()) {
                    System.out.println("The catalog's name is " + name.getName() + " with files:");
                    getFiles(name);
                }
            }
        }
    }
}
package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File(".\\src\\com\\urise\\webapp");
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

        System.out.println("--------------------------------------------------");

        //todo Сделать рекурсивный обход и вывод имени файлов в каталогах и подкаталогах (корневой каталог- ваш проект)
        File mainDir = new File("C:\\Users\\Ashcr\\Desktop\\TopJava\\basejava\\src\\com\\urise\\webapp");
        System.out.println("по указанному пути располагается каталог: " + mainDir.isDirectory());
        File[] files = mainDir.listFiles();

        if (files != null) {
            for (File name : files) {
                if (name.isDirectory()) {
                    System.out.println("The name of the catalog is " + name.getName());
                    getFiles(name);
                }
            }
        }
    }

    private static void getFiles(File searchDir) {
        File[] file = searchDir.listFiles();
        if (file != null) {
            for (File name : file) {
                if (name.isFile()) {
                    System.out.println("The file's name is " + name.getName());
                }
            }
        }
    }
}
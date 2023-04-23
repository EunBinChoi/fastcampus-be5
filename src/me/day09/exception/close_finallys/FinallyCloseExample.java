package me.day09.exception.close_finallys;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyCloseExample {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        // out directory absolute path
        final String PATH = FinallyCloseExample.class.getResource("").getPath();
        final String FILENAME = "input.txt";
        try {
            fileInputStream = new FileInputStream(PATH + FILENAME);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            int n = -1;
            while ((n = bufferedInputStream.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

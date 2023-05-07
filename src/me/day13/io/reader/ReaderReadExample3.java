package me.day13.io.reader;



import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderReadExample3 {
    static final String path = FileUtil.getOutPath( ReaderReadExample3.class );
    static final String filename = "long.txt";
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader(path + filename);
                Reader reader2 = new FileReader(path + filename);
        ) {

            int total = 0;
            int readCharNo = 0;
            char[] cbuf = new char[100];

            while ((readCharNo = reader.read(cbuf, 1, 5)) != -1) {
                for (int i = 1; i < readCharNo; i++) {
                    System.out.print(cbuf[i]);
                }
                total += readCharNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
            System.out.println();
            reader.close();
            //////////////////////////////////////////////////////////////////

            total = 0;
            while ( (readCharNo = reader2.read(cbuf, 0, 10)) != -1 ) {
                for (int i = 0; i < readCharNo; i++) {
                    System.out.print(cbuf[i]);
                }
                total += readCharNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}

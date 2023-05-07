package me.day13.io.file.writer;


import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterExample {
    static final String path = FileUtil.getOutPath( FileWriterExample.class );
    static final String filename = "output.txt";
    public static void main(String[] args) throws IOException {

        final String[] sentences = {":(\n", ":)\n", "TT\n", "^^\n"};


        try ( Writer writer = new FileWriter(path + filename, true) ) {
            // 파일이 없을 경우 파일을 생성
            // 이미 파일이 있을 경우에는 파일을 덮어씀

            writer.write("good day\n");
            writer.write("nice day\n");

            for (int i = 0; i < sentences.length; i++) {
                writer.write(sentences[i]);
            }
            writer.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}

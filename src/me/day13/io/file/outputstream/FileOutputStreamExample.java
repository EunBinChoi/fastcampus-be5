package me.day13.io.file.outputstream;

import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample {
    static final String path = FileUtil.getOutPath( FileOutputStreamExample.class );
    static final String filename = "output.txt";

    public static void main(String[] args) {

        final byte[] bytes = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        try ( OutputStream os = new FileOutputStream(path + filename) ) { // AutoClosable close()
            // 파일이 없을 경우 파일을 생성
            // 이미 파일이 있을 경우에는 파일을 덮어씀

            os.write(bytes);
            os.flush(); // OutputStream close() 호출하기 전에 flush() 호출이 됨 (명시적 작성)
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
        // OutputStream close()
    }
}

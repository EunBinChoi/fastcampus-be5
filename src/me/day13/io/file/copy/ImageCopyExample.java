package me.day13.io.file.copy;


import me.day13.io.util.FileUtil;

import java.io.*;

public class ImageCopyExample {
    static final String path = FileUtil.getOutPath( ImageCopyExample.class );
    static final String original = "dog.jpg";
    static final String copy = "dog_copy.jpg";

    public static void main(String[] args) {

        try (
                InputStream is = new FileInputStream(path + original); // auto close
                OutputStream os = new FileOutputStream(path + copy); // auto close
        ) {
            byte[] readBytes = new byte[256];
            int data;
            while ( (data = is.read(readBytes)) != -1 ) {
                // read()의 반환값: 실제 읽은 바이트 수 (int)
                os.write(readBytes, 0, data);
                // 그림 파일 / 256이 나누어떨어지지 않기 때문에
                // 실제 읽은 바이트 수만큼 써야함
            }
            os.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}

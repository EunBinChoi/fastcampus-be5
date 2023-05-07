package me.day13.io.file.copy;

import me.day13.io.util.FileUtil;

import java.io.*;
import java.util.StringTokenizer;

public class ImageCopyWithBufferedStreamExample {

    static final String path = FileUtil.getOutPath( ImageCopyWithBufferedStreamExample.class );

    public static String getCopyFileName( String filename ) {
        StringTokenizer stringTokenizer = new StringTokenizer(filename, ".");
        final String fileNameWithoutExtension = stringTokenizer.nextToken();
        final String extension = stringTokenizer.nextToken();

        String copy = "";
        int count = 0;
        while ( true ) {
            count++;
            copy = String.format("%s (%d).%s", fileNameWithoutExtension, count, extension);
            File copyFile = new File(copy);

            if (!copyFile.exists()) {
                try {
                    copyFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        return copy;
    }

    public static void main(String[] args) {

        final String filename = "dog.jpg";
        String copy = getCopyFileName(filename);


        /*
            Buffer 입출력 스트림: 입력/출력 성능 향상

             - 바이트 단위: BufferedInputStream, BufferedOutputStream
             - 문자 단위 :  BufferedReader, BufferedWriter
             - 자체적으로 입출력 불가능 (기존의 입출력 스트림에 연결해서 사용)
             - 버퍼의 사이즈 (8192)이 가득 찼을 때에만 입출력 수행
             - 마지막 버퍼에 남겨있는 데이터가 목적지로 가지 못할 수도 있음
             => flush() 수행해야 함!
         */

        try (
                InputStream fis = new FileInputStream(path + filename);
                BufferedInputStream bis = new BufferedInputStream(fis);

                OutputStream fos = new FileOutputStream(path + copy);
                BufferedOutputStream bos = new BufferedOutputStream(fos);

        ) {
            // 이미지 복사
            int data;
            while ( (data = bis.read()) != -1 ) {
                bos.write(data);
            }
            bos.flush();
            fos.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }

    }
}

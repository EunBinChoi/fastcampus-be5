package me.day13.io.object;


import me.day13.io.util.FileUtil;

import java.io.*;
import java.util.List;

public class ReadObjectStreamExample {
    static final String path = FileUtil.getOutPath( ReadObjectStreamExample.class );
    static final String filename = "students.dat";
    public static void main(String[] args) {
        /* 객체 입출력
         * - 객체는 문자가 아니기 때문에 바이트 기반 스트림으로 출력
         * - 객체의 필드들을 줄 세워야 함
         * - 직렬화 (serialization)
         * : 객체의 필드들이 일렬로 줄 세워서 연속적인 바이트로 변경
         *
         * - 역직렬화 (deserialization)
         * : 연속적인 바이트를 다시 객체로 복원하는 것
         * */

        // .dat: data file (binary 형식)
        try (
                InputStream fis = new FileInputStream(path + filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            Object data = ois.readObject();
            List<Student> studentList = null;

            if ( data instanceof List<?> ) {
                studentList = (List<Student>) data;
            }

            System.out.println(studentList);
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }
    }
}
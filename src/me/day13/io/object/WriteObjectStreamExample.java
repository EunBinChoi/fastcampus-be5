package me.day13.io.object;


import me.day13.io.util.FileUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WriteObjectStreamExample {
    static final String path = FileUtil.getOutPath( WriteObjectStreamExample.class );
    static final String filename = "students.dat"; // 이진파일
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
                OutputStream fos = new FileOutputStream(path + filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos); // 객체를 직렬화하가 위한 클래스 (보조 스트림)
        ) {

            List<Student> students = Arrays.asList(
                    new Student("sally", Student.Gender.FEMALE, Student.Grade.SENIOR, 15, "971010-2012234"),
                    new Student("kain", Student.Gender.MALE, Student.Grade.JUNIOR, 16, "980810-1212231"),
                    new Student("kalin", Student.Gender.MALE, Student.Grade.SENIOR, 17,  "910420-1042314"));
            oos.writeObject(students);
            oos.flush();
            fos.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
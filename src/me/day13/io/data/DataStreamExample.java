package me.day13.io.data;

import me.day13.io.util.FileUtil;

import java.io.*;

public class DataStreamExample {
    static final String path = FileUtil.getOutPath( DataStreamExample.class );
    static final String filename = "input.dat";
    public static void main(String[] args) {


        try (
                OutputStream fos = new FileOutputStream(path + filename); // 이진 파일
                DataOutputStream dos = new DataOutputStream(fos); // 보조 스트림 (데이터 형을 다양하게 쓸 수 있는)

                InputStream fis = new FileInputStream(path + filename); // 이진 파일
                DataInputStream dis = new DataInputStream(fis) // 보조 스트림 (데이터 형을 다양하게 읽을 수 있는)
        ) {

            /////////////////// write ////////////////////////
            dos.writeUTF("김자바");
            dos.writeInt(30);
            dos.writeDouble(12.34);
            dos.flush();
            fos.flush();

            //////////////////// read ///////////////////////
            // 파일에 쓴 순서대로 읽어야 함
            String name = dis.readUTF();
            int age = dis.readInt();
            double weight = dis.readDouble();

            System.out.println(name);
            System.out.println(age);
            System.out.println(weight);
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}

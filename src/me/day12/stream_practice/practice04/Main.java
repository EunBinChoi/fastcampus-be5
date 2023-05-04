//package me.day12.stream_practice.practice04;
//
//import me.day13.io.util.FileUtil;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    static final String path = FileUtil.getOutPath( Main.class );
//
//    public static String getCopyFileName( String filename ) {
//        StringTokenizer stringTokenizer = new StringTokenizer(filename, ".");
//        final String fileNameWithoutExtension = stringTokenizer.nextToken();
//        final String extension = stringTokenizer.nextToken();
//
//        String copy = "";
//        int count = 0;
//        while ( true ) {
//            count++;
//            copy = String.format("%s (%d).%s", fileNameWithoutExtension, count, extension);
//            File copyFile = new File(copy);
//
//            if (!copyFile.exists()) {
//                try {
//                    copyFile.createNewFile();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//            }
//        }
//        return copy;
//    }
//
//    public static void main(String[] args)  {
//
//        final String filename = "input.txt";
//        String copy = getCopyFileName(filename);
//
//        try (
//                InputStream fis = new FileInputStream(path + filename);
//                BufferedInputStream bis = new BufferedInputStream(fis);
//
//                OutputStream fos = new FileOutputStream(path + copy);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//        ) {
//            // 이미지 복사
//            int data;
//            while ( (data = bis.read()) != -1 ) {
//                bos.write(data);
//            }
//            bos.flush();
//            fos.flush();
//        } catch ( FileNotFoundException e ) {
//            throw new RuntimeException(e);
//        } catch ( IOException e ) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}

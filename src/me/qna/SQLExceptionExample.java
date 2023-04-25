package me.qna;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class SQLExceptionExample {
    public static void main(String[] args) {
        String str = "";
        try {
            str = select();
        } catch (SQLException e) {
            str = "null"; // SQLException 핸들링하기 위해 디폴트값 설정
        }
    }

    public static String select() throws SQLException {
        return null;
    }
}

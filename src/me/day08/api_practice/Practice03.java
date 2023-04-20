package me.day08.api_practice;

import java.util.StringTokenizer;

public class Practice03 {
    public static void main(String[] args) {
        final int ROW_NUM = 3;
        final int COL_NUM = 4;

        final String JSON_STRING =
                "{\n" +
                        "\t\"name\": \"Molecule Man\",\n" +
                        "\t\"age\": 29,\n" +
                        "\t\"secretIdentity\": \"Dan Jukes\",\n" +
                        "\t\"powers\": \"Radiation resistance\"\n" +
                        "},\n" +
                        "{\n" +
                        "\t\"name\": \"Madame Uppercut\",\n" +
                        "\t\"age\": 39,\n" +
                        "\t\"secretIdentity\": \"Jane Wilson\",\n" +
                        "\t\"powers\": \"Damage resistance\"\n" +
                        "},\n" +
                        "{\n" +
                        "\t\"name\": \"Eternal Flame\",\n" +
                        "\t\"age\": 1000000,\n" +
                        "\t\"secretIdentity\": \"Unknown\",\n" +
                        "\t\"powers\": \"Heat Immunity\"\n" +
                        "}";

        String[][] jsonTable = new String[ROW_NUM][COL_NUM];
        String[] columns = new String[COL_NUM];

        int count = 0;
        StringTokenizer jsonStrings = new StringTokenizer(JSON_STRING, ",");

        while (jsonStrings.hasMoreTokens()) {
            String jsonString = jsonStrings.nextToken().replaceAll("[{|}]", "").strip();
            StringTokenizer dataTokenizer = new StringTokenizer(jsonString, ":");
            String column = dataTokenizer.nextToken().replaceAll("\"", "").strip();
            String data = dataTokenizer.nextToken().replaceAll("\"", "").strip();

            int row = count / COL_NUM;
            int col = count % COL_NUM;

            columns[col] = column;
            jsonTable[row][col] = data;

            count++;
        }

        // (질문) 아래 코드는 왜 제대로 반복되지 않을까요?
//        for (int i = 0; i < jsonStrings.countTokens(); i++) {
//            System.out.println("i = " + i);
//            System.out.println(jsonStrings.nextToken());
//        }

        print(columns, jsonTable);
    }

    public static void print(String[] columnName, String[][] jsonTable) {
        System.out.println();
        System.out.println("\n---------------------------------------------------------------------------------------------");
        for (int i = 0; i < columnName.length; i++) {
            System.out.printf("| %20s ", columnName[i]);
        }
        System.out.printf("|");
        System.out.println("\n---------------------------------------------------------------------------------------------");
        for (int i = 0; i < jsonTable.length; i++) {
            for (int j = 0; j < jsonTable[i].length; j++) {
                System.out.printf("| %20s ", jsonTable[i][j]);
            }
            System.out.printf("|");
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}

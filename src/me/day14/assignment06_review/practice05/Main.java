package me.day14.assignment06_review.practice05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"name\": \"Madame Uppercut\",\n" +
                "  \"age\": 39,\n" +
                "  \"secretIdentity\": \"Jane Wilson\",\n" +
                "  \"powers\": [\n" +
                "    \"Million tonne punch\",\n" +
                "    \"Damage resistance\",\n" +
                "    \"Superhuman reflexes\"\n" +
                "  ],\n" +
                "  \"secretIdentity2\": \"Jane Wilson\",\n" +
                "  \"powers2\": [\n" +
                "    \"Million tonne punch\",\n" +
                "    \"Damage resistance\",\n" +
                "    \"Superhuman reflexes\"\n" +
                "  ]\n" +
                "}";

        Map<String, Object> jsonMap = parseJsonString(jsonString);

        jsonMap.entrySet().stream().forEach(entry -> {
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
            System.out.println();
        });

    }

    public static Map<String, Object> parseJsonString(String jsonString) {
        String[] jsonArr = jsonString.replaceAll("[{}\\[\\]\"]", "").split(",");
        Arrays.stream(jsonArr).forEach(System.out::println);


        String key = "";
        String value = "";
        String saveKey = "";
        List<String> values = new LinkedList<>(); // 여러개 value 저장
        Map<String, Object> jsonMap = new HashMap<>(); // 실제 parsing 결과
        for (int i = 0; i < jsonArr.length; i++) {
            if (jsonArr[i].contains(":")) {
                if (values.size() > 1) {
                    jsonMap.put(saveKey.strip(), values);
                }
                // 초기화
                saveKey = "";
                values = new LinkedList<>();

                ///////////////////////////////
                // 일반적인 경우
                int idx = jsonArr[i].indexOf(":");
                key = jsonArr[i].substring(0, idx);
                value = jsonArr[i].substring(idx + 1);

                jsonMap.put(key.strip(), value.strip());
                ///////////////////////////////

                values.add(value.strip()); // 임시 넣어놈

            } else {
                saveKey = key;
                values.add(jsonArr[i].strip());
            }
        }
        if (values.size() > 1) {
            jsonMap.put(saveKey.strip(), values);
        }

        return jsonMap;
    }
}

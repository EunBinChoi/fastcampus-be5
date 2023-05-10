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

        String key = "";
        String value = "";
        String saveKey = "";
        List<String> values = new LinkedList<>(); // value가 여러개일 수 있음을 가정
        Map<String, Object> jsonMap = new HashMap<>();
        for (int i = 0; i < jsonArr.length; i++) {
            if (jsonArr[i].contains(":")) {
                if (values.size() > 1) {
                    jsonMap.put(saveKey, values);
                }
                saveKey = "";
                values = new LinkedList<>();

                int idx = jsonArr[i].indexOf(":");
                key = jsonArr[i].substring(0, idx);
                value = jsonArr[i].substring(idx + 1);

                jsonMap.put(key.strip(), value.strip());
                values.add(value.strip());
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

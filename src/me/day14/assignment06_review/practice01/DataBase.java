package me.day14.assignment06_review.practice01;

import me.day11.assignment06.practice01.Table;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private static DataBase dataBase;
    private List<Table> tableList;

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public DataBase() {
        tableList = new LinkedList<>();
    }

    public DataBase(List<Table> tableList) {
        this.tableList = tableList;
    }


    public Table get(int i) {
        return tableList.get(i);
    }

    public boolean add(Table table) {
        return tableList.add(table);
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "tableList=" + tableList +
                '}';
    }
}

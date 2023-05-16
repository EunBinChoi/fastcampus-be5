package me.day15.smartstore.menu;

public enum OrderType {
    ASCENDING("오름차순"), DESCENDING("내림차순"),
    A("오름차순"), D("내림차순");

    String sortType = "";

    OrderType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return this.sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public OrderType replaceFullName() {
        if (this == A) return ASCENDING;
        else if (this == D) return DESCENDING;
        return this;
    }

    public static int size() {
        return OrderType.values().length / 2;
    }
}

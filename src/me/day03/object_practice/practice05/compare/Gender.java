package me.day03.object_practice.practice05.compare;

public enum Gender {
    MALE("남성"), FEMALE("여성");
    private String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}

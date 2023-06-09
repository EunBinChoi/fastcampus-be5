package me.day07.assignment03_review.practice01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDate;
    private Electronic[] electronicDevice;
    private LocalDateTime registerTime;

    public User() {
        registerTime = LocalDateTime.now(ZoneId.systemDefault());
    }

    public User(String userId, String userPassword, String userEmail) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate, Electronic[] electronicDevice) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevice = electronicDevice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronic[] getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(Electronic[] electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevice=" + Arrays.toString(electronicDevice) +
                ", registerTime=" + registerTime +
                '}';
    }
}

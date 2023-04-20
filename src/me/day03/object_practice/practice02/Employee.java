package me.day03.object_practice.practice02;

import java.util.Objects;

public class Employee { // google 에 다니는 직원들
    /* ID is auto-generated */
    private String eId;
    private String eName;
    private Position position;
    private Department department;
    private boolean isAuth;

    public static final String COMPANY = "GOOGLE";
    private static int total = 0;

    public Employee() {
        this.eId = String.format("%04d", (total+1));
        total++;
    }

    public Employee(String eName) {
        this.eId = String.format("%04d", (total+1));
        this.eName = eName;
        total++;
    }

    public Employee(String eName, Position position, Department department) {
        this.eId = String.format("%04d", (total+1));
        this.eName = eName;
        this.position = position;
        this.department = department;
        total++;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isAuth == employee.isAuth && Objects.equals(eId, employee.eId) && Objects.equals(eName, employee.eName) && position == employee.position && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eId, eName, position, department, isAuth);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", position=" + position +
                ", department=" + department +
                ", isAuth=" + isAuth +
                '}';
    }
}

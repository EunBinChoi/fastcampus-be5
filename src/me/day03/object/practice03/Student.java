package me.day03.object.practice03;

public class Student {
    private String sId;
    private String sName;
    public String regNum; // 추가
    private Semester currentSemester;

    private static int numOfStudent = 0;

    public Student() {
        numOfStudent++;
        sId = String.format("%04d", numOfStudent);
    }

    public Student(String sName, Semester currentSemester) {
        numOfStudent++;
        this.sId = String.format("%04d", numOfStudent);
        this.sName = sName;
        this.currentSemester = currentSemester;
    }

    public Student(String sName, String regNum, Semester currentSemester) {
        numOfStudent++;
        this.sId = String.format("%04d", numOfStudent);
        this.sName = sName;
        this.regNum = regNum;
        this.currentSemester = currentSemester;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Semester currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getRegNum(Employee employee) {
        if (employee.isAuth()) {
            return regNum;
        }
        return "not authorized";
    }

    private void setRegNum(String regNum, Employee employee) {
        if (employee.isAuth()) {
            this.regNum = regNum;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
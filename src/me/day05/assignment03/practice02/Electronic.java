package me.day05.assignment03.practice02;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    public enum Company {SAMSUNG, LG, APPLE} // 제조회사를 정의하기 위해 필요
    public enum AuthMethod {FINGERPRINT, PATTERN, PIN, FACE} // 전자제품을 인증하기 위해 필요

    private String productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;
    private static int total = 0;

    private String autoGenerator() {
        String order = String.format("%04d", total);
        String date = LocalDate.now(ZoneId.systemDefault()).toString().replace("-", "").substring(2);
        return date.concat(order);
    }


    public Electronic() {
        total++;
        productNo = autoGenerator();
    }

    public Electronic(String modelName) {
        this();
        this.modelName = modelName;
    }

    public Electronic(String modelName, Company companyName) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
    }

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
    }

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethods) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
    }

    public Electronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethods) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    // 실습 2-3
    public Electronic copy() {
        return new Electronic(
                productNo,
                modelName,
                companyName,
                LocalDate.from(dateOfMade),
                Arrays.copyOf(authMethods, authMethods.length));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }
}

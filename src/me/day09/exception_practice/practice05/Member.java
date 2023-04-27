package me.day09.exception_practice.practice05;

import me.day10.smartstore.arrays.DArray;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;


public class Member {
    enum Authority {ADMIN, USER}

    private String mId;
    private String mPw;
    private String mEmail;
    private String mAddress;

    private DArray<ShoppingCart> shoppingCarts;
    private DArray<ShoppingCart> orders;
    private LocalDateTime signupTime; // system time
    private Authority authority;


    private Member() {
        shoppingCarts = new DArray<>();
        orders = new DArray<>();
        signupTime = LocalDateTime.now(ZoneId.systemDefault());
        authority = Authority.USER;
    }

    public Member(String mId) {
        this.mId = mId;
    }

    public Member(String mId, String mPw) {
        this();
        this.mId = mId;
        this.mPw = mPw;

    }

    public Member(String mId, String mPw, String mEmail) {
        this();
        this.mId = mId;
        this.mPw = mPw;
        this.mEmail = mEmail;
    }

    public Member(String mId, String mPw, String mEmail, String mAddress) {
        this();
        this.mId = mId;
        this.mPw = mPw;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
    }

    public Member(String mId, String mPw, String mEmail, String mAddress, Authority authority) {
        this();
        this.mId = mId;
        this.mPw = mPw;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.signupTime = LocalDateTime.now(ZoneId.systemDefault());
        this.authority = authority;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String mPw) {
        this.mPw = mPw;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public DArray<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(DArray<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public DArray<ShoppingCart> getOrders() {
        return orders;
    }

    public void setOrders(DArray<ShoppingCart> orders) {
        this.orders = orders;
    }

    public LocalDateTime getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(LocalDateTime signupTime) {
        this.signupTime = signupTime;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(mId, member.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId);
    }

    @Override
    public String toString() {
        return "Member{" +
                "mId='" + mId + '\'' +
                ", mPw='" + mPw + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", shoppingCarts=" + shoppingCarts +
                ", orders=" + orders +
                ", signupTime=" + signupTime +
                ", authority=" + authority +
                '}';
    }
}

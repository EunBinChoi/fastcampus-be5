package me.day05.objectarrays;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;


public class Member {
    enum Authority {ADMIN, USER}

    private String mId;
    private String mPw;
    private String mEmail;
    private String mAddress;
    private LocalDateTime signupTime; // system time
    private Authority authority;

    public Member() {
        signupTime = LocalDateTime.now(ZoneId.systemDefault());
        authority = Authority.USER;
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
        return Objects.equals(mId, member.mId) && Objects.equals(mPw, member.mPw) && Objects.equals(mEmail, member.mEmail) && Objects.equals(mAddress, member.mAddress) && Objects.equals(signupTime, member.signupTime) && authority == member.authority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mPw, mEmail, mAddress, signupTime, authority);
    }

    @Override
    public String toString() {
        return "Member{" +
                "mId='" + mId + '\'' +
                ", mPw='" + mPw + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", signupTime=" + signupTime +
                ", authority=" + authority +
                '}';
    }
}

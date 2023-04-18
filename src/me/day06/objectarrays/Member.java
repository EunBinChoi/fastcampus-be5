package me.day06.objectarrays;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;


public class Member {
    enum Authority {ADMIN, USER}

    private String mId;
    private String mPw;
    private String mEmail;
    private String mAddress;

    private ShoppingCarts shoppingCarts;
    private Orders orders;
    private LocalDateTime signupTime; // system time
    private Authority authority;


    private Member() {
        shoppingCarts = new ShoppingCarts();
        orders = new Orders();
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

    public ShoppingCarts getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ShoppingCarts shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
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

    public void cart(ShoppingItem shoppingItem) {
        shoppingCarts.add(new ShoppingCart(shoppingItem, 1));
    }

    public void cart(ShoppingItem shoppingItem, int quantity) {
        shoppingCarts.add(new ShoppingCart(shoppingItem, quantity));
    }

    public void cancelCart(String shoppingCartNo) {
        int idx = shoppingCarts.indexOf(new ShoppingCart(shoppingCartNo));
        shoppingCarts.pop(idx);
    }

    // - 장바구니 -> 구매
    // - 바로 구매 ((장바구니) -> 구매)
    public void order() {
        orders.add(shoppingCarts.ordered(mAddress));
    }

    public void order(String address) {
        orders.add(shoppingCarts.ordered(address));
    }

    public void order(ShoppingItem shoppingItem) {
        cart(shoppingItem);
        order();
    }

    public void order(ShoppingItem shoppingItem, int quantity) {
        cart(shoppingItem, quantity);
        order();
    }

    public void order(ShoppingItem shoppingItem, int quantity, String address) {
        cart(shoppingItem, quantity);
        order(address);
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

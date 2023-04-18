package me.day06.objectarrays;

import java.util.Arrays;

public class Members {
    /////////////////////////////////////////
    // singleton
    private static Members allMembers;

    public static Members getInstance() {
        if (allMembers == null) {
            allMembers = new Members();
        }
        return allMembers;
    }
    /////////////////////////////////////////

    private Member[] members;

    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Members() {
        members = new Member[DEFAULT];
        capacity = DEFAULT;
    }

    public Members(int initial) {
        members = new Member[initial];
        capacity = initial;
    }

    public Members(Member[] members) {
        this.members = members;
        capacity = members.length;
        size = members.length;
    }

    public Member[] getMembers() {
        return members;
    }

    public void init() { // Members 초기화
        for (int i = 0; i < 10; i++) {
            allMembers.add(new Member(
                    Character.toString('a' + i),
                    Character.toString('a' + i) + "1234"
            ));
        }
    }

    /////////////////////////////////////////
    // CRUD (CREATE, READ, UPDATE, DELETE)
    public Member select(String mId) {
        if (mId == null) return null;

        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i).equals(new Member(mId))) return allMembers.get(i);
            // new Member(mId): create temporary member instance with argument mId.
        }
        return null;
    }

    public boolean insert(Member member) {
        if (member == null) return false;
        if (member.getmId() == null) return false;

        // id duplicate check (mId: PK)
        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i).equals(member)) return false;
        }

        allMembers.add(member);
        return true;
    }

    // member: eunbin1123, eunbin12345, asdasdas@gmail.com, "경기도 고양시,,,",,
    // Member member: 일부 필드는 수정이 되고 나머지 필드는 동일한 객체
    public boolean update(Member member) {
        if (member == null) return false;
        if (member.getmId() == null) return false;

        // find member's index
        int idx = indexOf(member);
        if (idx == -1) return false; // member is not found to be updated.

        allMembers.set(idx, member);
        return true;
    }

    public boolean delete(String mId) {
        if (mId == null) return false;

        // find member's index
        int idx = indexOf(new Member(mId));
        // new Member(mId): create temporary member instance with argument mId.
        if (idx == -1) return false; // member is not found to be updated.

        allMembers.pop(idx);
        return true;
    }

    /////////////////////////////////////////

    /////////////////////////////////////////
    // add, set, get, pop, indexOf, size, capacity (for dynamic-sized array)
    public int size() {
        return size;
    }

    // 배열에 얼마나 capacity 남아있는지 외부에 알려줄 필요가 없기 때문에 <private>으로 정의
    private int capacity() {
        return capacity;
    }

    public Member get(int index) {
        if (index < 0 || index >= size) return null;
        return members[index];
    }

    public void set(int index, Member member) {
        if (index < 0 || index >= size) return;
        if (member == null) return;

        members[index] = member;
    }

    public int indexOf(Member member) {
        if (member == null) return -1; // not found (instead of throwing exception)

        for (int i = 0; i < size; i++) {
            if (members[i] == null) continue;
            if (members[i].equals(member)) return i;
        }
        return -1; // not found
    }

    // 배열의 cap이 부족한 경우
    public void add(Member member) {
        if (member == null) return; // if argument is null, do not add null value in array

        if (size < capacity) {
            members[size] = member;
            size++;
        } else {
            grow();
            add(member);
        }
    }

    public void add(int index, Member member) {
        if (index < 0 || index >= size) return;
        if (member == null) return;

        if (size < capacity) {
            for (int i = size-1; i >= index ; i--) {
                members[i+1] = members[i];
            }
            members[index] = member;
            size++;
        } else {
            grow();
            add(index, member);
        }
    }

    public Member pop() {
//        if (size == 0) return null;
//
//        Member popElement = members[size-1];
//        members[size-1] = null;
//        size--;
//        return popElement;
        return pop(size-1);
    }

    public Member pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        Member popElement = members[index];
        members[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            members[i-1] = members[i];
        }
        members[size-1] = null;
        size--;
        return popElement;
    }

    public Member pop(Member member) {
        return pop(indexOf(member));
    }

    private void grow() {
        capacity *= 2; // doubling
        members = Arrays.copyOf(members, capacity);

        // size는 그대로
    }

    // NEW: 실제 객체 수만큼 객체 배열의 크기를 변경
    public Members trimToSize() { // 배열 객체가 더이상 추가되지 않을 때 => 정적 데이터
        members = Arrays.copyOf(members, size);
        capacity = size;

        return new Members(members);
    }
    /////////////////////////////////////////

    /////////////////////////////////////////
    // 프로그램 기능 구현을 위한 메소드
    public boolean login(String mId, String mPw) {
        if (mId == null || mPw == null) return false;

        int idx = indexOf(new Member(mId, mPw));
        if (idx == -1) return false; // mId is not found in DB.

        if (members[idx].getmId() == null || members[idx].getmPw() == null) return false;
        if (members[idx].getmId().equals(mId) && members[idx].getmPw().equals(mPw)) return true;
        return false;
    }

    public boolean revise(Member member) {
        if (member == null) return false;
        if (member.getmId() == null) return false;

        // find member's index
        int idx = indexOf(member);
        if (idx == -1) return false; // member is not found to be updated.

        members[idx].setmPw(member.getmPw());
        members[idx].setmEmail(member.getmEmail());
        members[idx].setmAddress(member.getmAddress());
        return true;
    }

    /////////////////////////////////////////

    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += (members[i] + "\n");
        }
        return toStr;
    }
}

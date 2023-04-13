package me.day05.objectarrays;

import java.util.Arrays;
import java.util.Objects;

public class Members {
    // singleton
    private static Members allMembers;

    public static Members getInstance() {
        if (allMembers == null) {
            allMembers = new Members();
        }
        return allMembers;
    }

    private Member[] members;

    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Members() {
        members = new Member[DEFAULT];
        capacity = DEFAULT;
    }
    private Members(int initial) {
        members = new Member[initial];
        capacity = initial;
    }

    private Members(Member[] members) {
        this.members = members;
        capacity = members.length;
        size = members.length;
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            allMembers.add(new Member(
                    Character.toString('a' + i),
                    Character.toString('a' + i) + "1234"
            ));
        }
    }

    //////////////////////////////////
    // CRUD
    public Member select(String mId) {
        if (mId == null) return null;

        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i) == null) continue;
            if (allMembers.get(i).getmId() == null) continue;
            if (allMembers.get(i).getmId().equals(mId)) return allMembers.get(i);
        }
        return null;
    }

    public Boolean insert(Member member) {
        if (member == null) return null;
        if (member.getmId() == null) return null;

        // id duplicate check
        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i) == null) continue;
            if (allMembers.get(i).getmId() == null) continue;
            if (allMembers.get(i).getmId().equals(member.getmId())) return false;
        }

        allMembers.add(member);
        return true;
    }
    public Boolean update(Member member) {
        if (member == null) return null;
        if (member.getmId() == null) return null;

        // find member's index
        int i = 0;
        for (i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i) == null) continue;
            if (allMembers.get(i).getmId() == null) continue;
            if (allMembers.get(i).getmId().equals(member.getmId())) break;
        }
        if (i == allMembers.size()) return false;

        allMembers.get(i).setmPw(member.getmPw());
        allMembers.get(i).setmEmail(member.getmEmail());
        allMembers.get(i).setmAddress(member.getmAddress());
        return true;
    }
    public Boolean delete(String mId) {
        if (mId == null) return null;

        // find member's index
        int i = 0;
        for (i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i) == null) continue;
            if (allMembers.get(i).getmId() == null) continue;
            if (allMembers.get(i).getmId().equals(mId)) break;
        }
        if (i == allMembers.size()) return false;

        allMembers.pop(i);
        return true;
    }
    //////////////////////////////////

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private boolean isNull() {
        return members == null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isValid(int index) {
        if (index < 0 || index > size) return false;
        return true;
    }

    public void set(int index, Member member) {
        if (isValid(index)) return;
        if (member == null) return;

        members[index] = member;
    }

    public Member get(int index) {
        if (isValid(index)) return null;
        return members[index];
    }

    public int indexOf(Member member) {
        if (member == null) return -1; // not found.

        for (int i = 0; i < size; i++) {
            if (members[i] == null) continue;
            if (members[i].equals(member)) return i;
        }
        return -1; // not found.
    }

    public void add(Member member) {
        if (member == null) return;

        if (size < capacity) {
            members[size] =member;
            size++;
        } else {
            grow();
            add(member);
        }
    }

    public void add(int index, Member member) {
        if (isValid(index)) return;
        if (member == null) return;

        if (size < capacity) {
            for (int i = members.length-1; i >= index; i--) {
                members[i+1] = members[i];
            }

            members[index] = member;
            size++;
        } else {
            grow();
            add(member);
        }
    }

    public void grow() {
        Member[] copied = Arrays.copyOf(members, members.length);
        capacity *= 2; // doubling.
        members = new Member[capacity];

        System.arraycopy(copied, 0, members, 0, copied.length);
        size = copied.length;
    }


    public void pop(int index) {
        if (size == 0) return;
        if (!(index >= 0 && index < size)) return;

        members[index] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = index + 1; j < size; j++) {
            members[j - 1] = members[j];
        }

        members[size - 1] = null;
        size--;
    }

    public void pop() {
        if (size == 0) return;

        members[size - 1] = null;
        size--;
    }

    public void pop(Member member) {
        if (size == 0) return;
        if (member == null) return;

        pop(indexOf(member));
    }

    public Members trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        Member[] newMembers = new Member[size];
        System.arraycopy(members, 0, newMembers, 0, size);

        members = newMembers;
        capacity = size;

        return new Members(newMembers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members1 = (Members) o;
        return size == members1.size && capacity == members1.capacity && Arrays.equals(members, members1.members);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(members);
        return result;
    }

    @Override
    public String toString() {
        return "Members{" +
                "members=" + Arrays.toString(members) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}

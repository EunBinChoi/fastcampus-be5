package me.day14.junit.asserts;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {

    @Test
    void assertArrayEqualsTest() {
        int[] integerList1 = new int[] {1, 2, 3, 4};
        int[] integerList2 = new int[] {1, 2, 3, 4};
        assertArrayEquals(integerList1, integerList2);
    }

    @Test
    void assertListEqualsTest() {
        List<Integer> integerList1 = List.of(1, 2, 3, 4);
        List<Integer> integerList2 = List.of(1, 2, 3, 4);
        assertEquals(integerList1.size(), integerList2.size());
        assertAll(() -> integerList1.equals(integerList2));
    }

    @Test
    void assertEqualTest() {
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        assertEquals(integer1, integer2);
    }

    @Test
    void assertNotEqualTest() {
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(2000);
        assertNotEquals(integer1, integer2);
    }

    @Test
    void assertSameTest() {
        Integer integer1 = Integer.valueOf(1);
        Integer integer2 = Integer.valueOf(1);
        assertSame(integer1, integer2);
    }

    @Test
    void assertNotSameTest() {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);
        assertNotSame(integer1, integer2);
    }

    @Test
    void asserTrueTest() {
        Boolean b = true;
        assertTrue(b);
    }

    @Test
    void asserFalseTest() {
        Boolean b = false;
        assertFalse(b);
    }

    @Test
    void asserNullTest() {
        String s = null;
        assertNull(s);
    }

    @Test
    void asserNotNullTest() {
        String s = "abc";
        assertNotNull(s);
    }

    @Test
    void failTest() {
        fail("fail test", new RuntimeException());
    }

}

package me.day08.time.instant;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantExample1 {
    public static void main(String [] args) throws InterruptedException {

        Instant instant1 = Instant.now();
        Thread.sleep(1000); // 1 sec

        Instant instant2 = Instant.now();

        if (instant1.isBefore(instant2)) { System.out.println("instant1이 빠르다."); }
        else if (instant2.isAfter(instant1)) { System.out.println("instant1이 느리다."); }
        else { System.out.println("동일한 시간이다."); }

        System.out.println("차이 (nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
    }
}

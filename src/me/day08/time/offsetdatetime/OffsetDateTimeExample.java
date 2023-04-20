package me.day08.time.offsetdatetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class OffsetDateTimeExample {
    public static void main(String[] args){
        final var barca = OffsetDateTime.of(LocalDateTime.of(2018, 5, 6, 20, 45, 0), ZoneOffset.of("+2"));
        // 2018-05-06T20:45+02:00
        System.out.println(barca);

        final var seoul = OffsetDateTime.of(LocalDateTime.of(2018, 5, 7, 3, 45, 0), ZoneOffset.of("+9"));
        // 2018-05-07T03:45+09:00
        System.out.println(seoul);

        // 둘을 UTC로 변환했을 때 같은 시간이기 때문에 둘은 같은 시간이라고 볼 수 있음
        // 2018-05-06T18:45Z
        System.out.println(barca.atZoneSameInstant(ZoneId.of("UTC")));
        // 2018-05-06T18:45Z
        System.out.println(seoul.atZoneSameInstant(ZoneId.of("UTC")));

        // 1970-01-01T00:00Z
        final var unixTimeOfUTC = OffsetDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        // 1970-01-01T00:00+09:00
        final var unixTimeOfUTC9 = OffsetDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.of("+9"));
        // false, 둘은 다른 ZoneOffset을 가짐
        System.out.println(unixTimeOfUTC);
        System.out.println(unixTimeOfUTC9);
        System.out.println(unixTimeOfUTC.equals(unixTimeOfUTC9));
        System.out.println();


        // 1970-01-01T00:00
        final var unixTimeOfUTCLocalDateTime = unixTimeOfUTC.toLocalDateTime();
        // 1970-01-01T00:00
        final var unixTimeOfUTCL9ocalDateTime = unixTimeOfUTC9.toLocalDateTime();
        System.out.println(unixTimeOfUTCLocalDateTime);
        System.out.println(unixTimeOfUTCL9ocalDateTime);
        // true, LocalDateTime은 ZoneOffset이 없기 때문에 둘 다 똑같은 걸로 취급함
        System.out.println(unixTimeOfUTCLocalDateTime.equals(unixTimeOfUTCL9ocalDateTime));
    }
}

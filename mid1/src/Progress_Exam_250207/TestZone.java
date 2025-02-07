package Progress_Exam_250207;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;

//타임존 변경시에는 withZoneSameInstant 메서드를 이용해야 한다.

public class TestZone {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 9, 0, 0);
        ZonedDateTime seoul = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        System.out.println("서울의 회의 시간 = " + seoul);
        ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("런던의 회의 시간 = " + london);
        ZonedDateTime newYork = seoul.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("뉴욕의 회의 시간 = " + newYork);
    }
}

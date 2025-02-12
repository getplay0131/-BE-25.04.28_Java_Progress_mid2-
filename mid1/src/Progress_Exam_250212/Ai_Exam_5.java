package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

//서울, 뉴욕, 런던의 회의 참석자들을 위한 회의 시간을 제안하는 프로그램을 작성하세요.
//- 입력: 서울 시간 (예: 2024년 3월 1일 오전 9시)
//- 출력: 각 도시의 현지 시간과 해당 시간이 업무 시간(9시-18시)에 해당하는지 여부
public class Ai_Exam_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("서울 시간을 입력해 주세요! : ");
        String startTime = reader.readLine();

        splitStr(startTime);


        reader.close();
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1]), Integer.parseInt(arrays[2]),
                Integer.parseInt(arrays[3])};
        substituteZone(intArr);
        return intArr;
    }

    public static String[] splitStr(String str) {
//        스트링빌더를 써야 겠다.
        String[] strArr = new String[4];
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        int arrayIdx = 0;
        int pmTime = 0;
        int times = 0;
        boolean isPmCheck = false;
        if (str.contains("오후") || str.toLowerCase().contains("pm")) {
            pmTime = 12;
            isPmCheck = true;
        }
        char[] strCharArray = str.toCharArray();
        for (int i = idx; i < str.length(); i++) {
            if (strCharArray[i] - '0' >= 0 && strCharArray[i] - '0' <= 9) {
                builder.append(strCharArray[i]);
            } else {
                if (builder.length() > 0) {
                    strArr[arrayIdx++] = builder.toString();
                    builder.setLength(0);
                }
            }
            idx = i;
        }
        int pmTimeInverter = 0;
        if (isPmCheck && strArr[3] != null) {
            pmTimeInverter = Integer.parseInt(strArr[3]);
            pmTimeInverter += pmTime;
        }
        strArr[3] = String.valueOf(pmTimeInverter);

        shapeConversion(strArr);
        return strArr;
    }

    public static void substituteZone(int[] arrays) {
        ZonedDateTime seoulZone = ZonedDateTime.of(arrays[0], arrays[1], arrays[2], arrays[3], 0, 0, 0, ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonZone = seoulZone.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("londonZone = " + londonZone + "-9시간");
        ZonedDateTime nyZone = seoulZone.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("nyZone = " + nyZone + "-14시간");
        meetingJudgementTime(londonZone);
        meetingJudgementTime(nyZone);
    }

    public static void meetingJudgementTime(ZonedDateTime ztimes) {
        if (ztimes.getHour() >= 9 && ztimes.getHour() <= 18) {
            System.out.println("대상 도시 : " + ztimes.getZone());
            System.out.println("업무 시간과 일치 합니다.");
            System.out.println("회의 요청이 가능합니다.");
        } else {
            System.out.println("대상 도시 : " + ztimes.getZone());
            System.out.println("업무 시간과 일치하지 않습니다.");
            System.out.println("회의 요청이 불가합니다.");
        }
    }
}

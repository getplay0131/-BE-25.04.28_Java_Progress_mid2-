package Exam_250320;

public class 문자열계산하기 {
    public int solution(String my_string) {
        int answer = 0;
        char operator = '1';
        String replace = "";
//        1단계. 스트링 빌더 호출
        StringBuilder builder = new StringBuilder();
//        2단계. 캐릭터 배열로 문자열을 변환 후 해당 값이 숫자인지 확인하기
        if (my_string.contains(" ")) {
            replace = my_string.replace(" ", "");
        }

        for (char c : replace.toCharArray()) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                builder.append(c);
//        3단계. 숫자가 아니며, 해당 값이 +인지 -인제에 따라 로직 나누기
            } else {
                if (answer == 0) {
                    answer = Integer.parseInt(builder.toString());
                    builder.setLength(0);
                } else {
                    if (operator == '+') {
                        answer += Integer.parseInt(builder.toString());
                        builder.setLength(0);
                    } else if (operator == '-') {
                        answer -= Integer.parseInt(builder.toString());
                        builder.setLength(0);
                    }
                }
                if (c == '+') {
                    operator = '+';
                    continue;
                } else if (c == '-') {
                    operator = '-';
                    continue;
                }
            }
        }
        if (builder.length() > 0) {
            if (operator == '+') {
                answer += Integer.parseInt(builder.toString());
                builder.setLength(0);
            } else if (operator == '-') {
                answer -= Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
        }

        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        String my_string = "3 + 4";
        int answer = 0;
        char operator = '1';
        String replace = "";
//        1단계. 스트링 빌더 호출
        StringBuilder builder = new StringBuilder();
//        2단계. 캐릭터 배열로 문자열을 변환 후 해당 값이 숫자인지 확인하기
        if (my_string.contains(" ")) {
            replace = my_string.replace(" ", "");
        }

        for (char c : replace.toCharArray()) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                builder.append(c);
//        3단계. 숫자가 아니며, 해당 값이 +인지 -인제에 따라 로직 나누기
            } else {
                if (answer == 0) {
                answer = Integer.parseInt(builder.toString());
                builder.setLength(0);
                } else {
                    if (operator == '+') {
                        answer += Integer.parseInt(builder.toString());
                        builder.setLength(0);
                    } else if (operator == '-') {
                        answer -= Integer.parseInt(builder.toString());
                        builder.setLength(0);
                    }
                }
                if (c == '+') {
                    operator = '+';
                    continue;
                } else if (c == '-') {
                    operator = '-';
                    continue;
                }
            }
        }
        if (builder.length() > 0) {
            if (operator == '+') {
                answer += Integer.parseInt(builder.toString());
                builder.setLength(0);
            } else if (operator == '-') {
                answer -= Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
        }

        System.out.println(answer);
    }


}
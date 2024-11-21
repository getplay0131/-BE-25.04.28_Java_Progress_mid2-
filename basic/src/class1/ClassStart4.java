package class1;

public class ClassStart4 {
    public static void main(String[] args) {
    Student Student1;
//    배열 선언과 비슷한 개념. 아래 코드처럼 선언 후 해당 클래스를 이용해 데이터 관련 작업이 가능
    Student1 = new Student();
    Student1.name = "학생1";
    Student1.age = 15;
    Student1.score = 90;

//    Student Student2;
//    Student2 = new Student();
    Student Student2 = new Student();
        Student2.name = "학생2";
        Student2.age = 16;
        Student2.score = 80;

        Student [] students = {Student1, Student2};

        System.out.println(" 이름 : " + students[0].name + " 나이 : " + students[0].age + " 성적 : " + students[0].score);
        System.out.println(" 이름 : " + students[1].name + " 나이 : " + students[1].age + " 성적 : " + students[1].score);

//        System.out.println(" 이름 : " + Student1.name + " 나이 : " + Student1.age + " 성적 : " + Student1.score);
//        System.out.println(" 이름 : " + Student2.name + " 나이 : " + Student2.age + " 성적 : " + Student2.score);
    }
}
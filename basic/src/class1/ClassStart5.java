package class1;

public class ClassStart5 {
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

        System.out.println(Student1.name);
        students[0].name = "학생입니다.";
        System.out.println(students[0].name);
        System.out.println(" ================== ");
        System.out.println(Student1.name);


        //        for (int i = 0; i < students.length; i++) {
//        System.out.println(" 이름 : " + students[i].name + " 나이 : " + students[i].age + " 성적 : " + students[i].score);
//        }



    }
}
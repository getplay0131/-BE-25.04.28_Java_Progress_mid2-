package Progress_250213.nested;

public class NestedOuter {
private static int outClassValue = 3;
private int outInstanceValue = 2;

static class Nested{
    private  int nestedInstanceValue = 1;

    public void print(){
//        자신의 필드에 접근
        System.out.println(nestedInstanceValue);

//        외부 클래스의 인스턴스 멤버 접근 불가 => outInstanceValue

//    외부 클래스의 일반 멤버는 접근 가능
        System.out.println(NestedOuter.outClassValue);
    }
}
}
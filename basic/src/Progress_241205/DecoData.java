package Progress_241205;

public class DecoData {
private  int instanceValue;
private static int staticValue;

public static void staticCall(){
//    data.instanceValue++;
//    data.instanceMethod();

    staticValue++;
    staticMethod();
}

    public static void staticCall(DecoData data){
    data.instanceValue++;
    data.instanceMethod();

        staticValue++;
        staticMethod();
    }

public void instanceCall(){
    instanceValue++;
    instanceMethod();

    staticValue++;
    staticMethod();
}

    private void instanceMethod(){
        System.out.println("instanceValue = " + instanceValue);
    }

    private static void staticMethod(){
        System.out.println("staticValue = " + staticValue);
    }

}
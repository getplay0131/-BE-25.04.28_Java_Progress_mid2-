package Progress_250401.generic.ex4;

public class GenericMethod {
    public static Object objMethod(Object obj){
        System.out.println("object print : " + obj);
        return obj;
    }

    public static <Type> Type genericMethod(Type t){
        System.out.println("generic print : "  + t );
        return t;
    }

    public static <Type extends Number> Type numberMethod(Type t){
        System.out.println("bound print : " + t);
        return t;
    }
}

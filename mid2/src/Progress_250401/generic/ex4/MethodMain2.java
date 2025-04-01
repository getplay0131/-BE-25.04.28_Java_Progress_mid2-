package Progress_250401.generic.ex4;

import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;
import Progress_250401.generic.ex3.AnimalHospitalV2;

public class MethodMain2 {
    public static void main(String[] args) {


            Dog dog = new Dog("댕댕1", 100);
            Cat cat = new Cat("냥냥1", 300);

//        개 병원
            AnimalMethod.checkUp(dog);

//        고양이 병원
            AnimalMethod.checkUp(cat);



//        문제2 : 개 타입 변환
        Dog anotherDog = new Dog("멍멍이", 150);
        new AnimalMethod().bigger(dog,anotherDog);
        System.out.println("anotherDog = " + anotherDog);


    }
}

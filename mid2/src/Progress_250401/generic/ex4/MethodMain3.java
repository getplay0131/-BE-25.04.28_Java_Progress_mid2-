package Progress_250401.generic.ex4;

import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class MethodMain3 {
    public static void main(String[] args) {


            Dog dog = new Dog("댕댕1", 100);
            Cat cat = new Cat("냥냥1", 50);

ComplexBox<Dog> hospital = new ComplexBox<>();
hospital.setAnimal(dog);

//        문제2 : 개 타입 변환

        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);

    }
}

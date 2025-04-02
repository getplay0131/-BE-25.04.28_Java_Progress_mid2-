package Progress_250402.generic.ex5;

import Progress_250331.generic.animal.Animal;
import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {

        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.setValue(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2( dogBox);

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);

    }
}

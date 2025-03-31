package Progress_250331.generic.ex2;

import Progress_250331.generic.animal.Animal;
import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class AnimalMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);


        Box<Animal> animalBox = new Box<>();
        animalBox.setValue(animal);
        Animal findAnimal = animalBox.getValue();
        System.out.println("findAnimal = " + findAnimal);
        animalBox.setValue(dog);
        Animal findDog = animalBox.getValue();
        System.out.println("findDog = " + findDog);
        animalBox.setValue(cat);
        Animal findCat = animalBox.getValue();
        System.out.println("findCat = " + findCat);
    }
}

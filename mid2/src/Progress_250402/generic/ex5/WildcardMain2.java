package Progress_250402.generic.ex5;

import Progress_250331.generic.animal.Animal;
import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class WildcardMain2 {
    public static void main(String[] args) {

        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

//        animal 포함 상위 타입 전달 가능
        writeBox(objectBox);
        writeBox(animalBox);
//        writeBox(dogBox); // 하한선이 animal이다. 즉 애니멀보다 위에 있는 객체 사용이 가능하다
//        writeBox(catBox);

        Animal animal = animalBox.getValue();
        System.out.println("animal = " + animal);

    }

    static void writeBox(Box<? super Animal>box){
        box.setValue(new Dog("멍멍이", 100));
    }
}

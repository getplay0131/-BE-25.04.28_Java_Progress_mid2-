package Progress_250401.generic.ex3;

import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class AnimalHospitalMainV2 {
    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogAnimalHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catAnimalHospital = new AnimalHospitalV2<>();

        Dog dog = new Dog("댕댕1", 100);
        Cat cat = new Cat("냥냥1", 300);

//        개 병원
        dogAnimalHospital.setAnimal(dog);
        dogAnimalHospital.checkUp();

//        고양이 병원
        catAnimalHospital.setAnimal(cat);
        catAnimalHospital.checkUp();

//        문제1: 개 병원에 고양이가 가면
//        dogAnimalHospital.setAnimal(cat); // 강이지만 가능

//        문제2 : 개 타입 변환
        dogAnimalHospital.setAnimal(dog);
        Dog biggerDog = (Dog) dogAnimalHospital.bigger(new Dog("댕댕2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}

package Progress_250401.generic.ex3;

import Progress_250331.generic.animal.Cat;
import Progress_250331.generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("댕댕1", 100);
        Cat cat = new Cat("냥냥1", 300);

//        개 병원
        dogHospital.setAnimal(dog);
        dogHospital.checkUp();

//        고양이 병원
        catHospital.setAnimal(cat);
        catHospital.checkUp();

//        문제1: 개 병원에 고양이가 가면
//        dogHospital.setAnimal(cat);

//        문제2 : 개 타입 변환
        dogHospital.setAnimal(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("댕댕2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}

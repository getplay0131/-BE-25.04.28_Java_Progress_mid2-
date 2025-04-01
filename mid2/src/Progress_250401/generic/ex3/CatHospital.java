package Progress_250401.generic.ex3;

import Progress_250331.generic.animal.Cat;

public class CatHospital {
    private Cat animal;

    public void setAnimal(Cat animal) {
        this.animal = animal;
    }

    public void checkUp(){
        System.out.println("동물 이름 : " +animal.getName());
        System.out.println("동물 크기 : " +animal.getSize());
        animal.sound();
    }

    public Cat bigger(Cat target){
        return animal.getSize() > target.getSize() ? animal : target;
    }
}

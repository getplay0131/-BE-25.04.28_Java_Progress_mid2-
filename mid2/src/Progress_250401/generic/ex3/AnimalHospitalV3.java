package Progress_250401.generic.ex3;

import Progress_250331.generic.animal.Animal;

public class AnimalHospitalV3<Type extends Animal> {
    private Type animal;

    public void setAnimal(Type animal) {
        this.animal = animal;
    }

    public void checkUp() {
        System.out.println("동물 이름 : " + animal.getName());
        System.out.println("동물 크기 : " + animal.getSize());
        animal.sound();

    }

    public Type bigger(Type target) {
        return (Type) (animal.getSize() > target.getSize() ? animal : target);
    }
}

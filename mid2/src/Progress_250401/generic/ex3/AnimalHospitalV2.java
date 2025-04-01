package Progress_250401.generic.ex3;

import Progress_250331.generic.animal.Animal;

public class AnimalHospitalV2<Type> {
    private Type animal;

    public void setAnimal(Type animal) {
        this.animal = animal;
    }

    public void checkUp() {
        animal.toString();
        animal.equals(null);
        if (animal instanceof Animal target) {
            System.out.println("동물 이름 : " + target.getName());
            System.out.println("동물 크기 : " + target.getSize());
            target.sound();
        }
    }

    public Type bigger(Type target) {
        if ( animal instanceof Animal animals && target instanceof Animal targets) {
            return (Type) (animals.getSize() > targets.getSize() ? animals : targets);
        }
        return null;
    }
}

package Progress_250401.generic.ex4;

import Progress_250331.generic.animal.Animal;

public class ComplexBox <T extends Animal> {
private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public <T> T printAndReturn(T t){
        System.out.println("animal.className : " + animal.getClass().getName());
        System.out.println("t.className : " + t.getClass().getName());
        return t;
    }
}

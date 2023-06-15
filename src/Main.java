import Entity.Animal;
import Helpers.AnimalHelper;

public class Main {
    public static void main(String[] args) {

        AnimalHelper animalHelper = new AnimalHelper();
        System.out.println("*****************Insert two records************");
        Animal animal = new Animal();
        animal.setName("Jack");
        animal.setTail(true);
        animalHelper.addAnimal(animal);

        animal = new Animal();
        animal.setName("Rocket");
        animal.setTail(false);
        animalHelper.addAnimal(animal);

        System.out.println("*****************Fetch all************");
        for (Animal animalTmp : animalHelper.getAnimalList()) {
            System.out.println(animalTmp);
        }
        System.out.println("*****************Fetch one************");
        Animal animalFetched = animalHelper.getAnimalById(1);
        System.out.println(animalFetched);

        System.out.println("*****************And delete it************");
        animalHelper.delAnimal(animalFetched);

        System.out.println("*****************Show rest************");
        for (Animal animalTmp : animalHelper.getAnimalList()) {
            System.out.println(animalTmp);
        }

        animalHelper.closeConnection();
    }
}
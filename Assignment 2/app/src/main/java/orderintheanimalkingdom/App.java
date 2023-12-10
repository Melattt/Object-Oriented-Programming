package orderintheanimalkingdom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for running the main.
 */
public class App {
  /**
   * Main.
   *
   * @param args Program arguments that are not used.
   */
  public static void main(String[] args) {

    ArrayList<Animal> animals = new ArrayList<Animal>();
    animals.add(new Reptile("Nile crocodile", "Crocodilus niloticus", 130.5, " ", "fresh water", true));
    animals.add(new Mammal("Tiger", "Panthera tigris", 425.5, " ", "yellow and black", true));
    animals.add(new Bird("Peafowl", "Pavo cristatus", 8.5, "Kaka-kaka", false, true, "in/on a hole in the ground"));
    animals.add(new Bird("Kiwi", "Apteryx mantelli", 10.8, " ", true, true, "in/on a hole in the ground"));
    animals.add(new Mammal("Swedish red and white cattle", "Bos Taurus", 18.7, "Muuuuu!", "red and white", true));
    animals.add(new Reptile("Green sea turtle", "Chelonia mydas", 108.5, " ", "the sea", false));

    Collections.sort(animals, Collections.reverseOrder());
    for (Animal animal : animals) {
      String[] arrayOfClasses = animal.getClass().getName().split("\\.");
      String nameOfClass = arrayOfClasses[1];
      if (nameOfClass.equals("Bird")) {
        Bird bird = (Bird) animal;
        System.out.println(bird.getLatinName() + " puts it's egg " + bird.getNestType());
      } else if (nameOfClass.equals("Mammal")) {
        Mammal mammal = (Mammal) animal;
        System.out.println(mammal.getLatinName() + " has a fur that is " + mammal.getFurColor());
      } else if (nameOfClass.equals("Reptile")) {
        Reptile reptile = (Reptile) animal;
        System.out.println(reptile.getLatinName() + " lives in " + reptile.getHabitat());
      }
    }
  }
}

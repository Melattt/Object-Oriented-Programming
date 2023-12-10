package theanimalkingdom;

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
    Mammal mammalX = new Mammal("Swedish red and white cattle", "Bos Taurus", 30.5, "Muuuuu!", "red and white", true);
    Bird birdX = new Bird("Peafowl", "Pavo cristatus", 8.5, "Kaka-kaka", false, true, "in/on a hole in the ground");
    Reptile reptileX = new Reptile("Comodo dragon", "Varanus komodoensis", 24.5, "kshhhhhh kshhhh", "Island", false);
    mammalX.makeSound();
    birdX.makeSound();
    reptileX.makeSound();
    System.out.println();
  }
}

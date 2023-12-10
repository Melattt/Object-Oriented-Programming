package singleplanet;

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

    // Planet Earth
    Planet planetEarth = new Planet();
    planetEarth.setName("planetEarth");
    planetEarth.setPosition(3);
    planetEarth.setNoMoons(1);
    planetEarth.setAphelion(152097701);
    planetEarth.setPerhelion(147098074);

    System.out.println(planetEarth.getName());
    System.out.println("  Position: " + planetEarth.getPosition());
    System.out.println("  Moons: " + planetEarth.getNoOfMoons());
    System.out.println("  Aphelion: " + planetEarth.getAphelion() + " km");
    System.out.println("  Perihelion: " + planetEarth.getPerihelion() + " km");


    // Planet Mars
    Planet planetMars = new Planet();
    planetMars.setName("planetMars");
    planetMars.setPosition(4);
    planetMars.setNoMoons(2);
    planetMars.setAphelion(249209300);
    planetMars.setPerhelion(206669000);

    System.out.println(planetMars.getName());
    System.out.println("  Position: " + planetMars.getPosition());
    System.out.println("  Moons: " + planetMars.getNoOfMoons());
    System.out.println("  Aphelion: " + planetMars.getAphelion() + " km");
    System.out.println("  Perihelion: " + planetMars.getPerihelion() + " km");
  }
}

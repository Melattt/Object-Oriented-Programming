package planetwithmoons;

import singleplanet.Planet;

/**
 * Class for running the main.
 */
public class App {
  /**
   * Main.
   *
   * @param args Program arguments that are not used.
   * @throws Exception exception.
   */

  public static void main(String[] args) throws Exception {
    Planetwithmoon planetX = new Planetwithmoon("Mars", 3, 2, 152097701, 147098074);
    planetX.addMoon(new Moon("Phobos", 22));
    planetX.addMoon(new Moon("Deimos", 12));
    System.out.println();

    int count = 1;
    System.out.println("The planet is called " + planetX.getName()
        + " and has the following moons:");

    for (Moon moon : planetX.getMoons()) {
      System.out.println("  Moon " + count + " is called "
          + moon.getName() + " (" + moon.getSizeInKm() + "km)");
      count++;
    }

    Planetwithmoon planetY = new Planetwithmoon("Earth", 4, 4, 249209300, 206669000);
    planetY.addMoon(new Moon("The moon", 3474));
    System.out.println();

    count = 1;
    System.out.println("The planet is called " + planetY.getName()
        + " and has the following moons:");

    for (Moon moon : planetY.getMoons()) {
      System.out.println("  Moon " + count + " is called "
          + moon.getName() + " (" + moon.getSizeInKm() + "km)");
      count++;
    }
    System.out.println();
  }
}
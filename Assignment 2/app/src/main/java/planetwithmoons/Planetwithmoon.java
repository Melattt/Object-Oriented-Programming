package planetwithmoons;

import java.util.ArrayList;

/**
 * Planet with moon class.
 */
public class Planetwithmoon {
  private String name;
  private int position;
  private int noOfMoons;
  private int aphelion;
  private int perihelion;
  private ArrayList<Moon> moons;

  /**
   * Planet constructor.
   *
   * @param name name.
   * @param position position.
   * @param noOfMoons noOfMoons.
   * @param aphelion aphelion.
   * @param perihelion perihelion.
   * @throws Exception exception.
   */
  public Planetwithmoon(String name, int position, int noOfMoons, int aphelion,
      int perihelion) throws Exception {
    this.name = nameLength(name);
    this.position = positive(position);
    this.noOfMoons = positive(noOfMoons);
    this.aphelion = positive(aphelion);
    this.perihelion = positive(perihelion);
    moons = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  /**
   * Method to get position.
   *
   * @return position.
   */
  public int getPosition() {
    return this.position;
  }

  public void setPosition(int newPos) {
    this.position = newPos;
  }

  /**
   * Method to get number of moons.
   *
   * @return noOfMoons.
   */
  public int getNoOfMoons() {
    return this.noOfMoons;
  }

  public void addMoon(Moon newMoon) {
    this.moons.add(newMoon);
  }

  /**
   * Method Array.
   *
   * @return moonArray
   */
  public Moon[] getMoons() {
    Moon[] moonArray = new Moon[this.moons.size()];
    for (int i = 0; i < this.moons.size(); i++) {
      moonArray[i] = moons.get(i);
    }
    return moonArray;
  }

  /**
   * Returns aphelion.
   *
   * @return aphelion.
   */
  public int getAphelion() {
    return this.aphelion;
  }

  public void setAphelion(int newAphelion) {
    this.aphelion = newAphelion;
  }

  /**
   * get Perihelion.
   *
   * @return perihelion
   */
  public int getPerihelion() {
    return this.perihelion;
  }

  public void setPerihelion(int newPerihelion) {
    this.perihelion = newPerihelion;
  }

  /**
   * Gets value.
   *
   * @return value.
   * @throws Exception exception.
   */
  private String nameLength(String val) throws Exception {
    if (val.length() < 2) {
      throw new Exception("Name of the planet should have at least 2 characters!");
    }
    return val;
  }

  /**
   * Gets positive number.
   *
   * @return positive number.
   * @throws Exception exception.
   */
  private int positive(int num) throws Exception {
    if (num < 0) {
      throw new Exception("The number should be positive!");
    }
    return num;
  }
}

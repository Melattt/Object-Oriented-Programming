package theanimalkingdom;

/**
 * This is the animal class.
 */
public abstract class Animal {
  private String name;
  private String latinName;
  private Double weight;
  protected String sound;

  /**
   * Gets name.
   *
   * @return getName.
   */
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets latin name.
   *
   * @return gets latin name.
   */
  public String getLatinName() {
    return this.latinName;
  }

  public void setLatinName(String latinName) {
    this.latinName = latinName;
  }

  /**
   * Gets weight.
   *
   * @return getWeight.
   */
  public Double getWeight() {
    return this.weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  /**
   * Gets sound.
   *
   * @return getSound.
   */
  public String getSound() {
    return this.sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  /**
   * Creates a new animal.
   *
   * @param name      name.
   * @param latinName latin name.
   * @param weight    weight.
   * @param sound     sound.
   */
  public Animal(String name, String latinName, Double weight, String sound) {
    this.name = name;
    this.latinName = latinName;
    this.weight = weight;
    this.sound = sound;
  }

  public abstract void makeSound();
}

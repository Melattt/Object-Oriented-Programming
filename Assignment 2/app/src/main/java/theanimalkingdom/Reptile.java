package theanimalkingdom;

/**
 * This is the reptile class.
 */
public class Reptile extends Animal {
  private String habitat;
  private Boolean isPoisonous;

  /**
   * Gets habitat.
   *
   * @return habitat.
   */
  public String getHabitat() {
    return this.habitat;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  /**
   * Is poisonous(true/false).
   *
   * @return getIsPoisonous.
   */
  public Boolean getIsPoisonous() {
    return this.isPoisonous;
  }

  public void setIsPoisonous(Boolean isPoisonous) {
    this.isPoisonous = isPoisonous;
  }

  /**
   * Creates a new reptile.
   *
   * @param name        name.
   * @param latinName   latin name.
   * @param weight      weight.
   * @param sound       sound.
   * @param habitat     habitat.
   * @param isPoisonous is poisonous.
   */
  public Reptile(String name, String latinName, Double weight, String sound,
      String habitat, boolean isPoisonous) {
    super(name, latinName, weight, sound);
    this.habitat = habitat;
    this.isPoisonous = isPoisonous;
  }

  @Override
  public void makeSound() {
    System.out.println("A " + getName() + " hizzes: " + getSound());
  }
}

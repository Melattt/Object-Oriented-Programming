package orderintheanimalkingdom;

/**
 * This is the bird class.
 */
public class Bird extends Animal {
  private Boolean isMigrant;
  private Boolean canFly;
  private String nestType;

  /**
   * Is migrant(true/false).
   *
   * @return isMigrant.
   */
  public Boolean getIsMigrant() {
    return this.isMigrant;
  }

  public void setIsMigrant(Boolean isMigrant) {
    this.isMigrant = isMigrant;
  }

  /**
   * Can fly(true/false).
   *
   * @return canFly.
   */
  public Boolean isCanFly() {
    return this.canFly;
  }

  public void setCanFly(Boolean canFly) {
    this.canFly = canFly;
  }

  /**
   * Gets nest type.
   *
   * @return nestType.
   */
  public String getNestType() {
    return this.nestType;
  }

  public void setNestType(String nestType) {
    this.nestType = nestType;
  }

  /**
   * Creates a new bird.
   *
   * @param name      name.
   * @param latinName latin name.
   * @param weight    weight.
   * @param sound     sound.
   * @param isMigrant is migrant.
   * @param canFly    can fly.
   * @param nestType  nest type.
   */
  public Bird(String name, String latinName, Double weight, String sound,
      boolean isMigrant, boolean canFly, String nestType) {
    super(name, latinName, weight, sound);
    this.isMigrant = isMigrant;
    this.canFly = canFly;
    this.nestType = nestType;
  }

  @Override
  public void makeSound() {
    System.out.println("A " + getName() + " tweets: " + getSound());
  }
}

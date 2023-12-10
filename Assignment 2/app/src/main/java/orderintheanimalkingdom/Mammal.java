package orderintheanimalkingdom;

/**
 * This is the mammal class.
 */
public class Mammal extends Animal {

  private String furColor;
  private boolean hasWinterFur;

  /**
   * Gets fur color.
   *
   * @return furColor.
   */
  public String getFurColor() {
    return this.furColor;
  }

  public void setFurColor(String furColor) {
    this.furColor = furColor;
  }

  /**
   * Has winter fur(true/false).
   *
   * @return hasWinterFur.
   */
  public boolean getHasWinterFur() {
    return this.hasWinterFur;
  }

  public void setHasWinterFur(boolean hasWinterFur) {
    this.hasWinterFur = hasWinterFur;
  }

  /**
   * Create a new mammal.
   *
   * @param name         name.
   * @param latinName    latin name.
   * @param weight       weight.
   * @param sound        sound.
   * @param furColor     fur color.
   * @param hasWinterFur has winter fur.
   */
  public Mammal(String name, String latinName, Double weight, String sound, String furColor, boolean hasWinterFur) {
    super(name, latinName, weight, sound);
    this.furColor = furColor;
    this.hasWinterFur = hasWinterFur;
  }

  @Override
  public void makeSound() {
    System.out.println("A " + getName() + " says: " + getSound());
  }
}

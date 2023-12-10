package planetwithmoons;

/**
 * This is the moon class.
 */
public class Moon {
  private String name;
  private int kmSize;

  /**
   * Gets name.
   *
   * @return name.
   */
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets size in km.
   *
   * @return size.
   */
  public int getSizeInKm() {
    return this.kmSize;
  }

  public void setSizeInKm(int kmSize) {
    this.kmSize = kmSize;
  }

  public Moon(String name, int kmSize) {
    this.name = name;
    this.kmSize = kmSize;
  }
}

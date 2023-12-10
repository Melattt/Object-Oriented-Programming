package monopoly;

/**
 * Represents the base of both the computer and human players, using ConsoleUi to offer the latter
 * a user interface and to offer the former a way of communicating its commands.
 */
public abstract class PlayerFoundation implements Player {
  private int funds;
  private ConsoleUi ui = null;
  private Tile currentTile;
  private String name;

  public Tile getCurrentTile()  {
    return currentTile;
  }

  public void setCurrentTile(Tile newTile)  {
    currentTile = newTile;
  }

  /**
   * Returns true of the player is currently positioned on a specific Tile.
   */
  public boolean isOnTile(Tile t) {
    return t == currentTile;
  }

  public ConsoleUi getUi()  {
    return ui;
  }

  public void setUi(ConsoleUi newUi)  {
    ui = newUi;
  }

  /**
   * Moves the player forward a number of steps and visits the tiles the player pass and stop on.
   * The tile the player stops on is reported as visited when the player moves forward.
   */
  protected void move(int steps) {
    currentTile.startOn(this);
    for (int i = 0; i < steps; i++) {
      currentTile.visit(this);
      currentTile = currentTile.getNext();
    }
    currentTile.stoppedOn(this);
  }

  /**
   * Returns the name of the player.
   */
  public String getName() {
    return name;
  }

  public void setName(String s) {
    name = s;
  }

  /**
   * Returns the funds of the player.
   */
  public int getFunds() {
    return funds;
  }

  public void setFunds(int newFunds)  {
    funds = newFunds;
  }

  /**
   * Call to make the player pay rent for a specific property.
   */
  public int payRent(int amount) {
    if (funds < amount) {
      amount = funds;
    }
    funds -= amount;
    ui.playerPaysRentFor(getName(), currentTile.toString(), amount);
    return amount;
  }

  /**
   * Call to deduce funds from the player. For example when buying a property.
   */
  public boolean deduceFunds(int cost) {
    if (funds > cost) { // we do not allow funds to go to 0, 0 = bankrupt
      funds -= cost;
      ui.playerFundsDeduced(getName(), cost);
      return true;
    } else {
      ui.playerUnableToPay(getName(), cost);
      return false;
    }
  }

  /**
   * Call to add funds to a player for example when passing the start tile.
   */
  public void addFunds(int amount) {
    funds += amount;
    ui.playerReceivedFunds(getName(), amount);
  }

  protected void buyCurrentTile() {
    if (currentTile.buy(this)) {
      ui.playerBuysProperty(getName(), currentTile.toString());
    }
  }
}

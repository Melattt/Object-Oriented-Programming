package monopoly;

/**
 * Represents a player and offers human interaction via ConsoleUi.
 */
public class HumanPlayer extends PlayerFoundation {

  /**
   * Creates a new human player.
   */
  public HumanPlayer(Tile currentTile, String name, ConsoleUi ui) {
    this.setName(name);
    this.setUi(ui);
    this.setFunds(500);
    this.setCurrentTile(currentTile);
    this.getCurrentTile().stoppedOn(this);
  }

  /**
   * Handles the interaction when it is the players turn to perform some actions.
   */
  public boolean yourTurn(Dice d1, Dice d2) {
    ConsoleUi.Action a = this.getUi().promptForAction(this.getName());
    switch (a) {
      case ROLL:
        d1.roll();
        d2.roll();
        final int steps1 = d1.getValue();
        final int steps2 = d2.getValue();
        this.getUi().playerMoves(getName(), steps1, steps2);
        move(steps1 + steps2);
        break;
      case BUY:
        this.buyCurrentTile();
        break;
      default:
        break;
    }

    return a == ConsoleUi.Action.ROLL;
  }
}

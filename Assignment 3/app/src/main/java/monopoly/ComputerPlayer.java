package monopoly;

import java.util.Random;

/**
 * Represents a bot.
 */
public class ComputerPlayer extends PlayerFoundation {
  Random rand = new Random();
  /**
   * The "situation" variable shows computer player's "situation" when buying
   * properties, where
   * higher level represents more impetuous and lower level represents more
   * attention.
   * .
   */
  private int situation = 0;

  /**
   * Creates a new computer player and sets it on a tile.
   */
  public ComputerPlayer(Tile currentTile, String name, ConsoleUi ui) {
    this.setName(name);
    this.setUi(ui);
    this.setCurrentTile(currentTile);
    this.getCurrentTile().stoppedOn(this);
    this.setFunds(500);
    situation = (rand.nextInt(6) + 1);
  }

  /**
   * Returns the computer player's situation level.
   */
  public String getsituation() {
    switch (situation) {
      case 1:
        return "Level1";
      case 2:
        return "Level2";
      case 3:
        return "Level3";
      case 4:
        return "Level4";
      case 5:
        return "Level5";
      case 6:
        return "Level6";
      default:
        return "Level3";
    }
  }

  /**
   * Generates and returns the bot's decisions based on its situation level.
   */
  public boolean yourTurn(Dice d1, Dice d2) {
    int c = 2;
    try {
      Thread.sleep(((rand.nextInt(4) + 3)) * 1000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    // Lack of try-catch functions when using Thread.sleep yields compile errors for
    // whatever reason.
    while (c != 0) {
      if (this.getFunds() < (9 - situation) * 100) {
        c = 0;
      } else {
        c = rand.nextInt(2);
      }
      switch (c) {
        case 0:
          d1.roll();
          d2.roll();
          final int steps1 = d1.getValue();
          final int steps2 = d2.getValue();
          this.getUi().playerMoves(getName(), steps1, steps2);
          move(steps1 + steps2);
          return true;
        case 1:
          this.buyCurrentTile();
          break;
        default:
          break;
      }
    }
    return true;
  }
}

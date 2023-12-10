package main.Recipe;
import java.util.ArrayList;
/**
 * This class uses search strategy to search recipes.
 */
public abstract class SearchStrategy {

  protected Input validIn;

  /* Constructor */
  public SearchStrategy(Input input) {
    validIn = input;
  }

  // Search strategy
  public abstract ArrayList<Recipe> GetSearchResults (ArrayList<Recipe> listToSearch);
}
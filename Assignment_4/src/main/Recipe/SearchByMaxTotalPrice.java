package main.Recipe;
import java.util.ArrayList;
/**
 * Performs a recipe search that returns all recipes whose total price of ingredients
 * is lower or equal to the given value.
 */
public class SearchByMaxTotalPrice extends SearchStrategy {

  /* Constructor */
  public SearchByMaxTotalPrice(Input input) {
    super(input);
  }

  // Prompts the user to input 
  private Double searchByPrice() {
    Double price = validIn.nextDoubleInRange("Enter max total price: ", 0, 9999999);
    return price;
  }

  // Search strategy
  public ArrayList<Recipe> GetSearchResults (ArrayList<Recipe> listToSearch) {
    Double searchParam = searchByPrice();
    ArrayList<Recipe> results = new ArrayList<Recipe>();
    for (Recipe recipe : listToSearch) {
        if (recipe.getTotalPrice(recipe.portions) <= searchParam) {
            results.add(recipe);
        }
    }
    return results;
  }
}
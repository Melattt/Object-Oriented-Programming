package main.Recipe;
import java.util.ArrayList;
/**
 * Performs a recipe search that returns all recipes whose
 * names begin with the given characters.
 */
public class SearchByNameBegins extends SearchStrategy {

  /* Constructor */
  public SearchByNameBegins(Input vi) {
    super(vi);
  }

  // Prompts the user to input 
  private String searchByRecipeName() {
    System.out.print("Enter recipe name: ");
    String recipeName = validIn.nextLine();
    return recipeName;
  }

  // Search strategy
  public ArrayList<Recipe> GetSearchResults (ArrayList<Recipe> listToSearch) {
    String searchParam = searchByRecipeName();
    ArrayList<Recipe> results = new ArrayList<Recipe>();
    for (Recipe recipe : listToSearch) {
      if (recipe.name.startsWith(searchParam)) {
        results.add(recipe);
      }
    }
    return results;
  }
}
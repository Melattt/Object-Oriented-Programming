package main.Recipe;
import java.util.ArrayList;

/* Performs a recipe search */
public class SearchByContainsIngredient extends SearchStrategy {

  /* Constructor */
  public SearchByContainsIngredient(Input vi) {
    super(vi);
  }

  // Prompts the user to input
  private String ingredientToSearch() {
    System.out.print("Ingredient to search for: ");
    String ingredient = validIn.nextLine();
    return ingredient;
  }

  public ArrayList<Recipe> getSearchResults (ArrayList<Recipe> listToSearch, String ingredientName) {
    String searchParam;
    if (ingredientName == null) {
      searchParam = ingredientToSearch();
    } else {
      searchParam = ingredientName;
    }
    ArrayList<Recipe> results = new ArrayList<Recipe>();
    for (Recipe recipe : listToSearch) {
      for (IngredientsList ingredientsListEntry : recipe.ingredients) {
        if (ingredientsListEntry.ingredient.name.equals(searchParam)) {
            results.add(recipe);
        }
      }
    }
    return results;
  }

  @Override
  public ArrayList<Recipe> GetSearchResults (ArrayList<Recipe> listToSearch) {
    return getSearchResults(listToSearch, null);
  }
}
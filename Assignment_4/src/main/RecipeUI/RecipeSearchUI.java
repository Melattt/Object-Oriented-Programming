package main.RecipeUI;
import java.util.ArrayList;

import main.Recipe.IngredientsData;
import main.Recipe.Print;
import main.Recipe.Recipe;
import main.Recipe.RecipesData;
import main.Recipe.SearchByContainsIngredient;
import main.Recipe.SearchByMaxTotalPrice;
import main.Recipe.SearchByNameBegins;
import main.Recipe.SearchStrategy;
import main.Recipe.Input;

public class RecipeSearchUI extends UserInterface {

  /* Constructor */
  public RecipeSearchUI(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData) {
    super(vi, pp, ingrData, rcpData);
  }

  /* Title of the User Interface class */
  protected String Title() { 
    return "Search Recipes"; 
  }

  // String containing the options
  protected String[] Choices() {
    return new String[]{
      "Name Begins With",
      "Contains Ingredient",
      "Maximum Total Price"
    };
  }

  // Choices
  protected void OnChoice(int choice) {
    switch (choice) {
      case 1:
        DisplaySearchResults(new SearchByNameBegins(validIn));
        break;
      case 2:
        DisplaySearchResults(new SearchByContainsIngredient(validIn));
        break;
      case 3:
        DisplaySearchResults(new SearchByMaxTotalPrice(validIn));
        break;
      default:
        break;
    }
  }

  private void DisplaySearchResults(SearchStrategy searchStrategy) {
    ArrayList<Recipe> results = searchStrategy.GetSearchResults(recipesData.GetAllRecipes());
    if (results.size() > 0) {
      prints.surroundPrintln(" Search Results ", '-');
      System.out.println();
      for (Recipe recipe : results) {
          prints.surroundPrintln(recipe.name, ' ');
      }
      System.out.println();
      prints.surroundPrintln("", '-');
    } else {
      prints.surroundPrintln(" The search gave no results. ", '-');
    }
  }
}
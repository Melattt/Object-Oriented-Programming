package main.RecipeUI;
import main.Recipe.IngredientsData;
import main.Recipe.Print;
import main.Recipe.RecipesData;
import main.Recipe.Input;

public class MainUI extends UserInterface {

  /* Constructor */
  public MainUI(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData) {
    super(vi, pp, ingrData, rcpData);
  }

  // Title of User Interface
  protected String Title() { 
    return "Main Menu"; 
  }

  protected String[] Choices() {
    return new String[]{
      "Check/Edit Ingredients",
      "Check/Edit Recipes"
    };
  }

  protected void OnChoice(int choice) {
    switch (choice) {
      case 1: 
        UserInterface ingredientsDataUI = new IngredientsDataUI(validIn, prints, ingredientsData, recipesData);
        ingredientsDataUI.Enter();
        break;
      case 2: 
        UserInterface recipesDataUI = new RecipesDataUI(validIn, prints, ingredientsData, recipesData);
        recipesDataUI.Enter();
        break;
      default:
        break;
    }
  }
}
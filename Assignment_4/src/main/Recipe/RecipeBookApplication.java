package main.Recipe;
import main.RecipeUI.MainUI;
import main.RecipeUI.UserInterface;

public class RecipeBookApplication {

  private static String pathIngredients = "./Ingredients.txt";
  private static String pathRecipes = "./Recipes.txt";

  // Application 
  public static void main(String[] args) throws Exception {

    /* Instantiates utility objects */
    FileOperations fileOperations = new FileOperations();
    Print prettyPrints = new Print();
    Input validIn = new Input();

    IngredientsData ingredientsData = new IngredientsData();
    ingredientsData.stringsToIngredients(fileOperations.toString(pathIngredients));
    RecipesData recipesData = new RecipesData(ingredientsData);
    recipesData.StringToRecipes(fileOperations.toString(pathRecipes));

    // Display Welcome message
    prettyPrints.surroundPrintln("");
    prettyPrints.surroundPrintln("     WELCOME    TO    THE    RECIPE    BOOK     ");
    prettyPrints.surroundPrintln("");

    // Main menu
    UserInterface MainUI = new MainUI(validIn, prettyPrints, ingredientsData, recipesData);
    MainUI.Enter();

    // Goodbye message
    prettyPrints.Println("\n Thank You For Using This App \n");

    // Save contents of IngredientsData and RecipesData to text files
    fileOperations.saveText(pathIngredients, ingredientsData.ingredientsToStrings());
    fileOperations.saveText(pathRecipes, recipesData.RecipesToString());
  }
}

package main.RecipeUI;
import java.util.ArrayList;

import main.Recipe.Ingredient;
import main.Recipe.IngredientsData;
import main.Recipe.IngredientsList;
import main.Recipe.Print;
import main.Recipe.Recipe;
import main.Recipe.RecipesData;
import main.Recipe.Input;


public class RecipeEditorUI extends UserInterface {

  private Recipe recipe;

  /* Constructor */
  public RecipeEditorUI(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData, Recipe r) {
    super(vi, pp, ingrData, rcpData);
    recipe = r;
  }

  @Override 
  protected int Menu() {
    if (recipe.name == "") { 
      return CreateNewRecipe();
    } else { 
      System.out.println(recipe.getRecipeAsString(recipe.portions, prints, ingredientsData.CURRENCY) + "\n");
      DisplayMenuWithTitleAndOptions(Title());
      return validIn.nextIntInRange("Select an option: ", 1, AmountOfChoices());
    }
  }

  /* Ttle of the User Interface class */
  protected String Title() { return "Editing Recipe: " + recipe.name; }

  protected String[] Choices() {
    return new String[]{
      "Change Recipe Name",
      "Change Default Portions Amount",
      "Add Ingredients To Recipe",
      "Create New Ingredient And Add To Recipe",
      "Delete Ingredients From Recipe",
      "Add Instructions",
      "Delete Instruction Line"
    };
  }

  protected void OnChoice(int choice) {
    switch (choice) {
      case 1:
        SetName();
        break;
      case 2:
        SetPortions();
        break;
      case 3:
        AddIngredients();
        break;
      case 4:
        createNewIngredientAndAddToRecipe();
        break;
      case 5:
        DeleteIngredients();
        break;
      case 6:
        AddInstructions();
        break;
      case 7:
        DeleteInstructions();
        break;
      default:
        break;
    }
  }

  // Creating a new recipe
  private int CreateNewRecipe() {
    prints.surroundPrintln(" Create New Recipe ", '=');
    SetName();
    if (recipe.name == "") {
      return Choices().length + 1;
    }
    SetPortions();
    AddIngredients();
    AddInstructions();
    return Choices().length + 1;
  }

  // Set name
  private void SetName() {
    recipe.name = validIn.nextLine("Name: ");
  }

  // Default portions 
  private void SetPortions() {
    double newPortions = validIn.nextDoubleInRange("Portions: ", 0, 9999999);
    if (recipe.ingredients.size() > 0) {
      boolean adjustIngredients = validIn.YesOrNo("Adjust ingredient amounts to new amount of portions? (Y/N) ");
      if (adjustIngredients) {
        for (IngredientsList ingredientsListEntry : recipe.ingredients) {
          ingredientsListEntry.amount = ingredientsListEntry.amount * (newPortions / recipe.portions);
        }
      }
    }
    recipe.portions = newPortions;
  }

  /* Create new ingredient and add to recipe */
  private void createNewIngredientAndAddToRecipe() {
    IngredientsDataUI ingredientsDataUI = new IngredientsDataUI(validIn, prints, ingredientsData, recipesData);
    Ingredient newIngredient = ingredientsDataUI.createNewIngredient();
    if (newIngredient != null) {
      IngredientsList ingredientsListEntry = CreateIngredientsListEntry(newIngredient);
      if (ingredientsListEntry != null) {
        recipe.addIngredientToList(ingredientsListEntry);
        System.out.println(ingredientsListEntry.amount + " " + ingredientsListEntry.ingredient.unit + "(s)" + " of " + ingredientsListEntry.ingredient.name
        + " was added to the ingredients list of the recipe.");
      }
    }
  }

  /* Adding ingredients to the recipe. */
  private void AddIngredients() {
    while (true) {
      prints.Println(recipe.getIngredientsListAsString(recipe.portions, prints));
      prints.surroundPrintln(" ADD INGREDIENT ", '=');
      String ingredientName = validIn.nextLine("Ingredient (leave empty to exit): ");
      if (ingredientName == null || ingredientName.equals("")) {
        break;
      } else {
        Ingredient ingredient = ingredientsData.getIngredient(ingredientName);
        if (ingredient == null) {
          System.out.println("\nIngredient not found.");
        } else {
          IngredientsList ingredientsListEntry = CreateIngredientsListEntry(ingredient);
          recipe.addIngredientToList(ingredientsListEntry);
          System.out.println(ingredientsListEntry.amount + " " + ingredientsListEntry.ingredient.unit + "(s)" + " of " + ingredientsListEntry.ingredient.name
          + " was added to ingredients list.");
        }
      }
    }
  }

  /* A new ingredients list entry. */
  private IngredientsList CreateIngredientsListEntry(Ingredient ingredient) {
    Double amount;
    if (ingredient.dividable) {
      amount = validIn.nextDoubleInRange("Amount: ", 0, 9999999);
    } else {
      amount = Double.valueOf(validIn.nextIntInRange("Amount must be even number as ingredient is non-dividable: ", 0, 9999999));
    }
    String guide = validIn.nextLine("guide: ");
    System.out.println("");
    return new IngredientsList(ingredient, amount, guide);
  }

  /* Adding instructions to the recipe. */
  private void AddInstructions() {
    prints.surroundPrintln(" ADD INSTRUCTIONS ", '=');
    while (true) {
      String instruction = validIn.nextLine("Instruction (empty to exit): ");
      if (instruction != null && !instruction.isBlank()) {
        recipe.addInstructionLine(instruction);
        System.out.println("\"" + instruction + "\"" + " was added to recipe instructions.");
      } else {
        break;
      }
    }
  }

  private void DeleteIngredients() {
    prints.surroundPrintln(" DELETE INGREDIENTS ", '=');
    while (true) {
      String ingredientName = validIn.nextLine("Ingredient to delete from recipe (empty to exit): ");
      if (ingredientName != null && !ingredientName.isBlank()) {
        ArrayList<Integer> ingredientsFound = recipe.findIngredientsInList(ingredientName);
        if (ingredientsFound.size() == 0) {
          prints.Println(ingredientName + " wasn't found in recipe ingredients list.");
        } else if (ingredientsFound.size() == 1) {
          recipe.deleteIngredientFromList(ingredientsFound.get(0));
          prints.Println(ingredientName + " was deleted from recipe.");
        } else {
          prints.Println("Which ingredients list entry do you want to delete?\n");
          int choiceID = 1;
          for (int i : ingredientsFound) {
            prints.Println(choiceID + ". " + recipe.ingredients.get(i).getDetails());
            choiceID++;
          }
          prints.Println(choiceID + ". Exit");
          prints.Println("");
          int ingredientToDeleteID = validIn.nextIntInRange("Select an option: ", 1, ingredientsFound.size() + 1);
          if (ingredientToDeleteID == ingredientsFound.size() + 1) {
            break;
          } else {
            recipe.deleteIngredientFromList(ingredientsFound.get(ingredientToDeleteID - 1));
            prints.Println(ingredientName + " was deleted from recipe.");
          }
        }
      } else {
          break;
      }
    }
  }

  private void DeleteInstructions() {
    prints.surroundPrintln(" DELETE INSTRUCTIONS ", '=');
    do {
      System.out.println("\n" + recipe.getInstructionsAsString(prints) + "\n");
      int choice = validIn.nextIntInRange("Index of the instruction to delete (enter 0 to exit): ", 0, recipe.instructions.size());
      if (choice == 0) {
        break;
      } else {
        recipe.deleteInstructionLine(choice - 1);
        prints.Println("Instruction was deleted from the recipe.");
      }
    } while (true);
  }
}
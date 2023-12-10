package main.RecipeUI;
import main.Recipe.IngredientsData;
import main.Recipe.Print;
import main.Recipe.RecipesData;
import main.Recipe.Input;

public abstract class UserInterface {

  protected Input validIn;
  protected Print prints;
  protected IngredientsData ingredientsData;
  protected RecipesData recipesData;

  /* Constructor */
  public UserInterface(Input vi, Print pp, IngredientsData ingrData, RecipesData rcpData) {
    validIn = vi;
    prints = pp;
    ingredientsData = ingrData;
    recipesData = rcpData;
  }

  // Enter
  public void Enter() {
    int lastChoice = -1;
    while (true) {
      int amountOfChoices = Choices().length;
      lastChoice = Menu();
      OnChoice(lastChoice);
      if (lastChoice == amountOfChoices + 1) {
        break;
      }
    }
  }

  protected int Menu() {
    DisplayMenuWithTitleAndOptions(Title());
    return validIn.nextIntInRange("Select an option: ", 1, AmountOfChoices());
  }
  
  protected int PrintChoicesArray(String[] choices) {
    int choiceID = 1;
    for (String string : choices) {
      prints.Println(choiceID + ". " + string);
      choiceID++;
    }
    return choices.length;
  }

  protected void DisplayMenuWithTitleAndOptions(String title) {
    prints.surroundPrintln(" " + title + " ", '=');
    System.out.println("");
    int amountOfChoices = PrintChoicesArray(Choices());
    prints.Println((amountOfChoices + 1) + ". Exit");
    prints.Println("");
  }

  // Size of the Choices array
  protected int AmountOfChoices() {
    return Choices().length + 1;
  }

  protected abstract String Title();

  protected abstract String[] Choices();

  protected abstract void OnChoice(int choice);
}
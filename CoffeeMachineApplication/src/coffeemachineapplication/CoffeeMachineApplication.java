/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author SachinVerma
 */
public class CoffeeMachineApplication {

    /**
     * @param args the command line arguments
     */
    public static void init() {
        System.out.println("Choose the following option : ");
        System.out.println("Press r/R to refill ingredients...");
        System.out.println("Press q/Q to close the Coffee Machine...");
        System.out.println("Press the front number to choose the drink...");
        System.out.println('\n');
    }
    public static void main(String[] args) {
        init();
        List<Ingredient> ingredients = Default.getDefaultIngredients();
        Map<Ingredient, Integer> ingredientStock = ingredients.stream().collect(Collectors.toMap(ingredient -> ingredient, ingredient -> 15));
        List<Drink> drinks = Default.getDefaultDrinks();

        CoffeeMachine coffeeMachine = new CoffeeMachine(ingredients, ingredientStock, drinks);
        CoffeeMachineDisplay coffeeMachineDisplay = new CoffeeMachineDisplay(coffeeMachine);

        do {
            coffeeMachineDisplay.displayCurrentStock();
            coffeeMachineDisplay.displayMenu();
        } while (coffeeMachineDisplay.processInputAndContinue());
    }
    
}

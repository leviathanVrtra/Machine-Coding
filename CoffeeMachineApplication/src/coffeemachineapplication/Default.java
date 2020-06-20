/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SachinVerma
 */
public final class Default {
    private Default() {
        throw new UnsupportedOperationException();
    }

     private static final List<Ingredient> DEFAULT_INGREDIENTS =
        Arrays.asList(
            new Ingredient("Coffee Syrup"),
            new Ingredient("Elaichi Syrup"),
            new Ingredient("Ginger Syrup"),
            new Ingredient("Sugar Syrup"),
            new Ingredient("Tea Leaves"),
            new Ingredient("Hot Milk"),
            new Ingredient("Hot Water")
        );

    public static List<Ingredient> getDefaultIngredients() {
        return new ArrayList<>(DEFAULT_INGREDIENTS);
    }

    private static final List<Drink> DEFAULT_DRINKS = new ArrayList<>();
    static {
        IngredientSearcher ingredientSearcher = new IngredientSearcher(getDefaultIngredients());
        DEFAULT_DRINKS.add(new Drink("Coffee", Arrays.asList(
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Milk"),
            ingredientSearcher.search("Hot Milk"),
            ingredientSearcher.search("Coffee Syrup"),
            ingredientSearcher.search("Sugar Syrup")
        )));
        DEFAULT_DRINKS.add(new Drink("Ginger Tea", Arrays.asList(
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Milk"),
            ingredientSearcher.search("Tea Leaves"),
            ingredientSearcher.search("Ginger Syrup"),
            ingredientSearcher.search("Sugar Syrup")
        )));
        DEFAULT_DRINKS.add(new Drink("Elaichi Tea", Arrays.asList(
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Water"),
            ingredientSearcher.search("Hot Milk"),
            ingredientSearcher.search("Tea Leaves"),
            ingredientSearcher.search("Elaichi Syrup"),
            ingredientSearcher.search("Sugar Syrup")
        )));
        DEFAULT_DRINKS.add(new Drink("Hot Milk", Arrays.asList(
            ingredientSearcher.search("Hot Milk"),
            ingredientSearcher.search("Hot Milk")
        )));
        DEFAULT_DRINKS.add(new Drink("Hot Water", Arrays.asList(
            ingredientSearcher.search("Hot Water")
        )));
    }

    public static List<Drink> getDefaultDrinks() {
        return new ArrayList<>(DEFAULT_DRINKS);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author SachinVerma
 */
public class CoffeeMachineDisplay {
    private final CoffeeMachine coffeeMachine;
    private final Scanner scanner = new Scanner(System.in);

    private final List<Ingredient> indexedIngredients;
    private final List<Drink> indexedDrinks;

    public CoffeeMachineDisplay(final CoffeeMachine coffeeMachine) {
        this.coffeeMachine = Objects.requireNonNull(coffeeMachine, "coffeeMachine");
        this.indexedIngredients = coffeeMachine.getIngredients().stream().sorted(Comparator.comparing(Ingredient::getName)).collect(Collectors.toList());
        this.indexedDrinks = coffeeMachine.getDrinks().stream().sorted(Comparator.comparing(Drink::getName)).collect(Collectors.toList());
    }

    public void displayCurrentStock() {
        for (Ingredient ingredient : indexedIngredients) {
            int currentStock = coffeeMachine.getCurrentStock(ingredient);
            System.out.println("Ingredient: " + ingredient.getName() + " / Current Stock: " + currentStock);
        }
        System.out.println();
    }

    public void displayMenu() {
        for (int i = 0; i < indexedDrinks.size(); i++) {
            Drink drink = indexedDrinks.get(i);
            System.out.print((i + 1) + ". Drink: " + drink.getName());
            if (coffeeMachine.isOutOfStock(drink)) {
                System.out.print(" [Out of stock]");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static final Pattern IS_DIGIT_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern IS_R_PATTERN = Pattern.compile("^[rR]$");
    private static final Pattern IS_Q_PATTERN = Pattern.compile("^[qQ]$");

    public boolean processInputAndContinue() {
        System.out.print("Dispensing: ");

        String input = scanner.next();
        System.out.println();
        if (IS_DIGIT_PATTERN.matcher(input).matches()) {
            int selectedDrink = Integer.parseInt(input);
            if (selectedDrink < 1 || selectedDrink > indexedDrinks.size()) {
                System.out.println("Invalid drink number");
                System.out.println();
                return true;
            }
            Drink drink = indexedDrinks.get(selectedDrink - 1);
            if (coffeeMachine.isOutOfStock(drink)) {
                System.out.println("Drink " + drink + " some ingredients are not available");
                System.out.println();
                return true;
            }
            coffeeMachine.makeDrink(drink);
            return true;
        }
        if (IS_R_PATTERN.matcher(input).matches()) {
            Map<Ingredient, Integer> newStock = coffeeMachine.getIngredients().stream().collect(Collectors.toMap(ingredient -> ingredient, ingredient -> 15));
            coffeeMachine.restock(newStock);
            System.out.println("Restocked");
            System.out.println();
            return true;
        }
        if (IS_Q_PATTERN.matcher(input).matches()) {
            System.out.println("Closed");
            return false;
        }
        System.out.println("Invalid input");
        System.out.println();
        return true;
    }
}

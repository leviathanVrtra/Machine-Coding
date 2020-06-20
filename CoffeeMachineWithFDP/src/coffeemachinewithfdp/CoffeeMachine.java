/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachinewithfdp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SachinVerma
 */
public class CoffeeMachine {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final Map<Ingredient, Integer> ingredientStock = new HashMap<>();
    
    CoffeeMachine(final Collection<? extends Ingredient> ingredients, final Map<? extends Ingredient, Integer> ingredientStock) {
        this.ingredients.addAll(ingredients);
        this.ingredientStock.putAll(ingredientStock);
        this.ingredients.forEach(ingredient -> this.ingredientStock.putIfAbsent(ingredient, 0));
    }
    
    public List<Ingredient> getIngredient() {
        return new ArrayList<>(ingredients);
    }
    
    
}

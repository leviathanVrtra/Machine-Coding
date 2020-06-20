/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachinewithfdp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author SachinVerma
 */
public class CoffeeMachineWithFDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Ingredient> ingredients = Default.getDefaultIngredients();
        Map<Ingredient, Integer> indexedStock = ingredients.stream().collect(Collectors.toMap(ingredient -> ingredient, ingredient -> 15));
        
        System.out.println(ingredients);
        System.out.println(indexedStock);
    }
    
}

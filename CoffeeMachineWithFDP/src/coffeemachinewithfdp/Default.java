/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachinewithfdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author SachinVerma
 */
public final class Default {
    private Default() {
       
    }
    private static final List<Ingredient> defaultIngredient = Arrays.asList(
                                        new Ingredient("Coffee Syrup"),
                                        new Ingredient("Elaichi Syrup"),
                                        new Ingredient("Ginger Syrup"),
                                        new Ingredient("Suger Syrup"),
                                        new Ingredient("Tea Leaves"),
                                        new Ingredient("Hot Water"),
                                        new Ingredient("Hot Milk")
                                    );
    
    public static List<Ingredient> getDefaultIngredients() {
        return new ArrayList<>(defaultIngredient);
    }
}

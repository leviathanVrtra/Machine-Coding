/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachinewithfdp;

import java.util.Objects;

/**
 *
 * @author SachinVerma
 */
public class Ingredient {
    private final String ingredientName;
    
    public Ingredient(final String name) {
        this.ingredientName = Objects.requireNonNull(name, "Ingredient name can't be empty...");
    }
    
    public String getName() {
        return this.ingredientName;
    }
    
    @Override
    public String toString() {
        return "(" + ingredientName + ")";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author SachinVerma
 */
public class Ingredient {
    private final String name;

    public Ingredient(final String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ingredient that = (Ingredient)obj;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "(" + name + ")";
    }
    
    public static IngredientSearcher createSearcher(final Collection<? extends Ingredient> ingredients) {
        return new IngredientSearcher(ingredients);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author SachinVerma
 */
public class Drink {
    private final String name;
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Drink(final String name, final Ingredient... ingredients) {
        this(name, Arrays.asList(ingredients));
    }

    public Drink(final String name, final Collection<? extends Ingredient> ingredients) {
        this.name = Objects.requireNonNull(name, "name");
        this.ingredients.addAll(ingredients);
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public Map<Ingredient, Long> getIngredientCount() {
        return ingredients.stream()
            .collect(Collectors.groupingBy(ingredient -> ingredient, Collectors.counting()));
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Drink drink = (Drink)obj;

        if (!ingredients.equals(drink.ingredients)) return false;
        if (!name.equals(drink.name)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + ingredients + ")";
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ingredients.hashCode();
        return result;
    }

    public static DrinkSearcher createSearcher(final Collection<? extends Drink> drinks) {
        return new DrinkSearcher(drinks);
    }
}

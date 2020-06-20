/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.Collection;

/**
 *
 * @author SachinVerma
 */
public class DrinkSearcher extends Searcher<String, Drink> {
    public DrinkSearcher(final Collection<? extends Drink> drinks) {
        super(Drink::getName, drinks);
    }
}

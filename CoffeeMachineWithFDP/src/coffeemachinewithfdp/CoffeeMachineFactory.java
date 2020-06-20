/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachinewithfdp;

/**
 *
 * @author SachinVerma
 */
public class CoffeeMachineFactory {
    public static CoffeeMachine buildDrink(DrinkType drink) {
        CoffeeMachine drinkObj = null;
        switch(drink) {
            case COFFEE :
                drinkObj = new Coffee();
                break;
            case GINGER_TEA :
                drinkObj = new GingerTea();
                break;
            case ELAICHI_TEA :
                drinkObj = new ElaichiTea();
                break;
            case GREEN_TEA :
                drinkObj = new GingerTea();
                break;
            case JAGGERY_TEA :
                drinkObj = new JaggeryTea();
                break;
            case HOT_MILK :
                drinkObj = new HotMilk();
                break;
            case HOT_WATER :
                drinkObj = new HotWater();
                break;
            default :
                System.out.println("Invalid Drink...");
                break;
        }
        return drinkObj;
    }
}

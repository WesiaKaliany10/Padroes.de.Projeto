/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import modelos.Pizza;

/**
 *
 * @author Wésia
 */
public abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        super(pizza.getSabor(), pizza.getValorPizza());
        this.pizza = pizza;
    }
    
}

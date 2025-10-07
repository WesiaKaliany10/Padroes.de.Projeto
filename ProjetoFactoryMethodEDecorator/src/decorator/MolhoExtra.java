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
public class MolhoExtra extends PizzaDecorator{
    
    private double valorAdicional = 5.0;

    public MolhoExtra (Pizza pizza) {
    super(pizza);
    setValor (getValorPizza() + valorAdicional);
    }

    @Override
    public String assarPizza() {
    return pizza.assarPizza() + "Com molho";
    
    }
    
}

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
public class Azeitona extends PizzaDecorator{

    private double valorAdicional = 5.0;
       
    public Azeitona (Pizza pizza) {
        super(pizza);
          setValor (getValorPizza() + valorAdicional);
    }

    @Override
    public String assarPizza() {
    return pizza.assarPizza() + "Com azeitona";
    
    }
    
}

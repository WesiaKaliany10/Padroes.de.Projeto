/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Wésia
 */
    public class PizzaFrango extends Pizza {

    public PizzaFrango() {
        super("Frango", 42.00);
    }

    @Override
    public String assarPizza() {
        return ("Assando pizza de Frango");
    }
   
}



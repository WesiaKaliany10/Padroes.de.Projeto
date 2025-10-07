/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Wésia
 */
public class PizzaMarguerita extends Pizza {

    public PizzaMarguerita() {
        super("Marguerita", 40.00);
    }

    @Override
    public String assarPizza() {
        return ("Assando pizza de Marguerita");
    }
  
    
}

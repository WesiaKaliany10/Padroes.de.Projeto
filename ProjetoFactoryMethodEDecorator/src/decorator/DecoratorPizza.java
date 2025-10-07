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
public class DecoratorPizza {
    
    public static Pizza aplicarAdicionais(
            Pizza pizza,
            boolean queijoExtra,
            boolean bacon,
            boolean cebola,
            boolean molhoExtra,
            boolean bordaRecheada,
            boolean azeitona) {
        
        if (queijoExtra) {
            pizza = new QueijoExtra(pizza);
        }
        if (bacon) {
            pizza = new Bacon(pizza);
        }
        if (cebola) {
            pizza = new Cebola(pizza);
        }
        if (molhoExtra) {
            pizza = new MolhoExtra(pizza);
        }
        if (bordaRecheada) {
            pizza = new BordaRecheada(pizza);
        }
        if (azeitona) {
            pizza = new Azeitona(pizza);
        }
        
        return pizza;
    }
}
    


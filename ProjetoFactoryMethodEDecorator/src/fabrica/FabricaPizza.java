package fabrica;

import modelos.Pizza;
import modelos.PizzaCalabresa;
import modelos.PizzaFrango;
import modelos.PizzaMarguerita;
import modelos.PizzaPortuguesa;
import modelos.PizzaQuatroQueijos;

public class FabricaPizza {

    public static Pizza criarPizza(String tipo) {
        switch (tipo.toLowerCase()) {
            case "calabresa":
                return new PizzaCalabresa();
            case "quatro queijos":
                return new PizzaQuatroQueijos();
            case "frango":
                return new PizzaFrango();
            case "marguerita":
                return new PizzaMarguerita();
            case "portuguesa":
                return new PizzaPortuguesa();
                 default:
                throw new IllegalArgumentException("Tipo de pizza inválido: " + tipo);
         
        }
    }
    
}
    


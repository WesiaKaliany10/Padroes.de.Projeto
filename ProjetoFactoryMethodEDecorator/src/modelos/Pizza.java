/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Wésia
 */
public abstract class Pizza {
    
   private String sabor;
   private double valor;
   
   public abstract String assarPizza();

    public Pizza(String sabor, double valorPizza) {
        this.sabor = sabor;
        this.valor = valorPizza;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getValorPizza() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}

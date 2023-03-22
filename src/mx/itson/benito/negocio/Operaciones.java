/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.negocio;

import java.util.List;
import mx.itson.benito.entidades.ArticuloComprado;

/**
 * Clase de operaciones basicas
 * @author Carlos Daniel Rebollo Toledo 
 */
public class Operaciones {
    /**
     * Metodo para calcular el subTotal
     * @param articulosComprados Lista de articulos comprados para sumar sus precios
     * @return El subTotal
     */
    public static double calcularSubTotal(List<ArticuloComprado> articulosComprados){
        double subTotal = 0;
        
        for(ArticuloComprado a : articulosComprados){
            subTotal = (a.getArticulo().getPrecio() * a.getCantidad()) + subTotal;
        }
       
        return subTotal;
    }
    /**
     * Metodo para calcular el Total
     * @param subTotal Valor donde se agregara el iva
     * @return El Total
     */
    public static double calcularTotal(double subTotal){
        double total = 0;
        
        total = subTotal + (subTotal * 0.16);
        
        return total;
    }
}

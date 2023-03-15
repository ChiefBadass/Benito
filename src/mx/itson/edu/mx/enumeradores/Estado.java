/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mx.itson.edu.mx.enumeradores;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author carlo
 */
public enum Estado {
    @SerializedName ("1")
    Abierto,
    @SerializedName ("2")
    Cerrado,
    @SerializedName ("3")
    Cancelado
}

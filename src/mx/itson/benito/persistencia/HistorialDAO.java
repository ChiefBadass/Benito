/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.ArticuloComprado;
import mx.itson.benito.entidades.Historial;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class HistorialDAO {
    public static List<Historial> obtenerTodos(){
        List<Historial> historiales = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Historial> criteriaQuery = session.getCriteriaBuilder().createQuery(Historial.class);
            criteriaQuery.from(Historial.class);
            historiales = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrio un error; "+ ex.getMessage());
        }
    return historiales;
    }
    
    public static boolean guardar(Date fecha, OrdenCompra ordenCompra){
    boolean resultado = false;    
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Historial h = new Historial();
        h.setFecha(fecha);
        h.setOrdenCompra(ordenCompra);
   
        session.save(h);
        
        session.getTransaction().commit();
        
        resultado = h.getId() !=0;
        
    }catch(Exception ex){
        System.out.println("Ocurrio un error: " + ex);
    }
    return resultado;
    }
    
}

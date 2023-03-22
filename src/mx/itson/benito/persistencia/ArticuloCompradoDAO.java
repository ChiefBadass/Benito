/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.ArticuloComprado;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class ArticuloCompradoDAO {
    /**
     * Metodo para obtener a todos los conductores
     * @return Una lista de conductores
     */
    public static List<ArticuloComprado> obtenerTodos(){
        List<ArticuloComprado> articulos = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<ArticuloComprado> criteriaQuery = session.getCriteriaBuilder().createQuery(ArticuloComprado.class);
            criteriaQuery.from(ArticuloComprado.class);
            articulos = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrio un error; "+ ex.getMessage());
        }
    return articulos;
    }
    
    public static boolean guardar(Articulo articulo, int cantidad, OrdenCompra ordenCompra){
    boolean resultado = false;    
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        ArticuloComprado ac = new ArticuloComprado();
        ac.setArticulo(articulo);
        ac.setCantidad(cantidad);
        ac.setOrdenCompra(ordenCompra);
        
        session.save(ac);
        
        session.getTransaction().commit();
        
        resultado = ac.getId() !=0;
        
    }catch(Exception ex){
        System.out.println("Ocurrio un error: " + ex);
    }
    return resultado;
    }
    
    public static ArticuloComprado obtenerPorId(int id){
        ArticuloComprado articulo = null;
        try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                articulo = session.get(ArticuloComprado.class, id);
        }catch(HibernateException ex){
                System.err.println("Ocurrio un error: " + ex.getMessage());
        }
    return articulo;
    }

    
    public static boolean eliminar(int id){
    boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArticuloComprado articulo = session.get(ArticuloComprado.class, id);
            
            if(articulo!=null){
                session.delete(articulo);
                session.getTransaction().commit();
            resultado = true;
            }
        }catch(Exception ex){
             System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}

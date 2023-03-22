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
 * Clase de persistencia entre un articulo comprado y la base de datos
 * @author Carlos Daniel Rebollo Toledo
 */
public class ArticuloCompradoDAO {
    /**
     * Metodo para obtener a todos los articulos comprados
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
    /**
     * Metodo para guardar un articulo comprado
     * @param articulo Articulo que se va a guardar
     * @param cantidad Cantidad del articulo
     * @param ordenCompra Id de la compra
     * @return True si el articulo se guardo bien
     */
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
    /**
     * Metodo para obtener el id de un articulo comprado
     * @param id Id para buscar el articulo
     * @return El articulo seleccionado
     */
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

    /**
     * Metodo para eliminar un articulo comprado
     * @param id Id del articulo
     * @return True si el articulo se elimino correctamente
     */
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

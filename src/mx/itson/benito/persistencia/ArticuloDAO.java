/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Clase de persistencia de un articulo a la base de datos
 * @author Carlos Daniel Rebollo Toledo
 */
public class ArticuloDAO {
    /**
     * Metodo para obtener a todos los conductores
     * @return Una lista de conductores
     */
    public static List<Articulo> obtenerTodos(){
        List<Articulo> articulos = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Articulo> criteriaQuery = session.getCriteriaBuilder().createQuery(Articulo.class);
            criteriaQuery.from(Articulo.class);
            articulos = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrio un error; "+ ex.getMessage());
        }
    return articulos;
    }
    /**
     * Metodo para guardar un articulo
     * @param clave 
     * @param nombre
     * @param descripcion
     * @param precio
     * @param proveedor
     * @return 
     */
    public static boolean guardar(String clave, String nombre, String descripcion, double precio, Proveedor proveedor){
    boolean resultado = false;    
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Articulo a = new Articulo();
        a.setClave(clave);
        a.setNombre(nombre);
        a.setDescripcion(descripcion);
        a.setPrecio(precio); 
        a.setProveedor(proveedor);
        session.save(a);
        
        session.getTransaction().commit();
        
        resultado = a.getId() !=0;
        
    }catch(Exception ex){
        System.out.println("Ocurrio un error: " + ex);
    }
    return resultado;
    }
    
    public static Articulo obtenerPorId(int id){
        Articulo articulo = null;
        try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                articulo = session.get(Articulo.class, id);
        }catch(HibernateException ex){
                System.err.println("Ocurrio un error: " + ex.getMessage());
        }
    return articulo;
    }

    
    public static boolean editar(int id, String clave, String nombre, String descripcion, double precio, Proveedor proveedor){
    boolean resultado = false;
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Articulo articulo = obtenerPorId(id);
        if(articulo != null){
            articulo.setClave(clave);
            articulo.setNombre(nombre);
            articulo.setDescripcion(descripcion);
            articulo.setPrecio(precio);
            articulo.setProveedor(proveedor);
            session.saveOrUpdate(articulo);
            session.getTransaction().commit();
            resultado = true;
        }

    }catch(Exception ex){
        System.err.println("Ocurrio un error: " + ex.getMessage());
    }
    return resultado;
    }
    
    public static boolean eliminar(int id){
    boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Articulo articulo = session.get(Articulo.class, id);
            
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.ArticuloComprado;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import mx.itson.edu.mx.enumeradores.Estado;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class OrdenCompraDAO {
    /**
     * Metodo para obtener a todos los conductores
     * @return Una lista de conductores
     */
    public static List<OrdenCompra> obtenerTodos(){
        List<OrdenCompra> ordenesCompras = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<OrdenCompra> criteriaQuery = session.getCriteriaBuilder().createQuery(OrdenCompra.class);
            criteriaQuery.from(OrdenCompra.class);
            ordenesCompras = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrio un error; "+ ex.getMessage());
        }
    return ordenesCompras;
    }
    
    public static boolean guardar(String folio, Date fecha, Proveedor proveedor, double subTotal, double total, Estado estado, String comentario){
    boolean resultado = false;    
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        OrdenCompra o = new OrdenCompra();
        o.setFolio(folio);
        o.setFecha(fecha);
        o.setProveedor(proveedor);
        o.setSubTotal(subTotal);
        o.setTotal(total);
        o.setEstado(estado);
        o.setComentario(comentario);
        session.save(o);
        
        session.getTransaction().commit();
        
        resultado = o.getId() !=0;
        
    }catch(Exception ex){
        System.out.println("Ocurrio un error: " + ex);
    }
    return resultado;
    }
    
    public static OrdenCompra obtenerPorId(int id){
        OrdenCompra ordenCompra = null;
        try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                ordenCompra = session.get(OrdenCompra.class, id);
        }catch(HibernateException ex){
                System.err.println("Ocurrio un error: " + ex.getMessage());
        }
    return ordenCompra;
    }

    
    public static boolean editar(int id, String folio, Date fecha, Proveedor proveedor, double subTotal, double total, Estado estado){
    boolean resultado = false;
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        OrdenCompra ordenCompra = obtenerPorId(id);
        if(ordenCompra != null){
            ordenCompra.setFolio(folio);
            ordenCompra.setFolio(folio);
            ordenCompra.setProveedor(proveedor);
            ordenCompra.setSubTotal(subTotal);
            ordenCompra.setTotal(total);
            ordenCompra.setEstado(estado);
            session.saveOrUpdate(ordenCompra);
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
            OrdenCompra ordenCompra = session.get(OrdenCompra.class, id);
            
            if(ordenCompra!=null){
                session.delete(ordenCompra);
                session.getTransaction().commit();
            resultado = true;
            }
        }catch(Exception ex){
             System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}

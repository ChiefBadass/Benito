/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.benito.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Usuario;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class UsuarioDAO {
    /**
     * Metodo para obtener a todos los conductores
     * @return Una lista de conductores
     */
    public static List<Usuario> obtenerTodos(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Usuario> criteriaQuery = session.getCriteriaBuilder().createQuery(Usuario.class);
            criteriaQuery.from(Usuario.class);
            usuarios = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.err.println("Ocurrio un error; "+ ex.getMessage());
        }
    return usuarios;
    }
}

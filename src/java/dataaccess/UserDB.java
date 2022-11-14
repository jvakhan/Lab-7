package dataaccess;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.*;
import javax.persistence.*;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class UserDB {

    public List<User> getAll() {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    
    
    public boolean insert(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
            try {
            trans.begin();
            em.persist(user);
            trans.commit();
            return true;
            } catch (Exception ex) {
            trans.rollback();
            return false;
            } finally {
            em.close();
            }


    }
    
    public User get(String email) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        return em.createNamedQuery("User.findByEmail", User.class).getSingleResult();
    }
    
    
    public boolean update(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        
        EntityTransaction trans = em.getTransaction();
            try {
            trans.begin();
            em.merge(user);
            trans.commit();
            return true;
            } catch (Exception ex) {
            trans.rollback();
            return false;
            } finally {
            em.close();
            }
    }
    
    public boolean delete(User user) throws Exception {
          EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        
        EntityTransaction trans = em.getTransaction();
            try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
            return true;
            } catch (Exception ex) {
            trans.rollback();
            return false;
            } finally {
            em.close();
            }
    }


}

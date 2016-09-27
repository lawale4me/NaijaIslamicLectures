/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Lecturers;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Ahmed
 */
@Stateless
public class LecturerRepo     extends AbstractDAO<Lecturers>{

    private static final Logger logger = Logger.getLogger(LecturerRepo.class.getName());

    public LecturerRepo() {
        super(Lecturers.class);
    }
              
    
    public Lecturers validate(String username,String passwd) {
        EntityManager em = getEntityManager();
        Lecturers user = null;
        try {
            String query = "SELECT u FROM Lecturers u WHERE u.username = :username and u.password = :password";
        List<Lecturers> adminUser = em.createQuery(query, Lecturers.class).setParameter("username", username).setParameter("password", passwd).getResultList();
        return adminUser.isEmpty() ? null : adminUser.get(0);          
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return user;
    }
    
    public List<Lecturers> findAll() {
        EntityManager em = getEntityManager();
        List<Lecturers> device = new ArrayList();
        try {
            device =  em.createNamedQuery("Lecturers.findAll").getResultList();
            if (device != null && !device.isEmpty()) {
                return device;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return null;
    } 
    
     public List<Lecturers> findAllActive() {
        EntityManager em = getEntityManager();
        List<Lecturers> device = new ArrayList();
        try {
            device =  em.createNamedQuery("Lecturers.findAllActive").getResultList();
            if (device != null && !device.isEmpty()) {
                return device;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return null;
    } 
       
    
}

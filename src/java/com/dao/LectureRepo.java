/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Lecturers;
import com.entities.Lectures;
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
public class LectureRepo     extends AbstractDAO<Lectures>{

    private static final Logger logger = Logger.getLogger(LectureRepo.class.getName());

    public LectureRepo() {
        super(Lectures.class);
    }
              
    
    public Lectures validate(String username,String passwd) {
        EntityManager em = getEntityManager();
        Lectures user = null;
        try {
            String query = "SELECT u FROM Lectures u WHERE u.username = :username and u.password = :password";
        List<Lectures> adminUser = em.createQuery(query, Lectures.class).setParameter("username", username).setParameter("password", passwd).getResultList();
        return adminUser.isEmpty() ? null : adminUser.get(0);          
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return user;
    }
    
    public List<Lectures> findAll() {
        EntityManager em = getEntityManager();
        List<Lectures> device = new ArrayList();
        try {
            device =  em.createNamedQuery("Lectures.findAll").getResultList();
            if (device != null && !device.isEmpty()) {
                return device;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return null;
    } 
    
    public List<Lectures> findAllActive() {
        EntityManager em = getEntityManager();
        List<Lectures> device = new ArrayList();
        try {
            device =  em.createNamedQuery("Lectures.findAllActive").getResultList();
            if (device != null && !device.isEmpty()) {
                return device;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return null;
    }

    public List<Lectures> findByLecturer(Lecturers lecturer) {
        EntityManager em = getEntityManager();
        List<Lectures> device = new ArrayList();
        try {
            device =  em.createNamedQuery("Lectures.findByLecturerId").setParameter("lecturerId", lecturer).getResultList();
            if (device != null && !device.isEmpty()) {
                return device;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exception caught", e);
        }
        return null;
    }
       
    
}

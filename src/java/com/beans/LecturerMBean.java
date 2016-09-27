/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;


import com.dao.LectureRepo;
import com.dao.LecturerRepo;
import com.entities.Lecturers;
import com.entities.Lectures;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ahmed
 */
@ManagedBean
@ViewScoped
public class LecturerMBean implements Serializable {

    /**
     * Creates a new instance of ProductMBean
     */
    public LecturerMBean() {
    }
            
    Lecturers lecturer;    
    private Lectures lecture;    
    private List<Lecturers> lecturersList;    
    private List<Lectures> lectureList;    
    private Integer lecturerId,lectureId;
    private String lectID,lecturername,alias;
    
    @Inject 
    LecturerRepo lecturerrepo;
    @Inject 
    LectureRepo lecturerepo;
   

    @PostConstruct
    public void init() {        
        lecturersList = lecturerrepo.findAllActive();
        
    }                      

    public Lecturers getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturers lecturer) {
        this.lecturer = lecturer;
    }

    public List<Lecturers> getLecturersList() {
        return lecturersList;
    }

    public void setLecturersList(List<Lecturers> lecturersList) {
        this.lecturersList = lecturersList;
    }                               

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLectID() {
        return lectID;
    }

    public void setLectID(String lectID) {
        this.lectID = lectID;
    }        
    
    public void handleChange(){  
        System.out.println("LecturerId: "+lecturerId);
        lecturer = lecturerrepo.find(lecturerId);
        lectureList= lecturerepo.findByLecturer(lecturer);
    }
    
    public void handlePlay(){  
        System.out.println("LectureId: "+lectureId);
        lecture = lecturerepo.find(lectureId);        
    }

    public List<Lectures> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lectures> lectureList) {
        this.lectureList = lectureList;
    }

    public Lectures getLecture() {
        return lecture;
    }

    public void setLecture(Lectures lecture) {
        this.lecture = lecture;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public String getLecturername() {
        return lecturername;
    }

    public void setLecturername(String lecturername) {
        this.lecturername = lecturername;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void addLecturer(){
        RequestContext context = RequestContext.getCurrentInstance();
        Lecturers lect=new Lecturers();
        lect.setRegDate(new Date());
        lect.setFullName(lecturername);
        lect.setAlias(alias);
        lect.setStatus(0);
        try{
        lecturerrepo.create(lect);
        }catch(Exception ex){
          ex.printStackTrace();
          FacesMessage msg = new FacesMessage("Error:"+ex.getMessage());   
          FacesContext.getCurrentInstance().addMessage(null, msg);                                 
        }
        lecturername="";
        alias="";
        FacesMessage msg = new FacesMessage("Lecturer added pending approval");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        context.addCallbackParam("loggedIn", true);        
    }
    
}

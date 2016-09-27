/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;


import com.core.Util;
import com.dao.LectureRepo;
import com.dao.LecturerRepo;
import com.entities.Lecturers;
import com.entities.Lectures;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ahmed
 */
@ManagedBean
@RequestScoped
public class LectureMBean {

    /**
     * Creates a new instance of ProductMBean
     */
    public LectureMBean() {
    }
    
    boolean checked;
    private String title,url,source;
    Lectures lecture;    
    Lecturers lecturer;
    private List<Lectures> lectureList ;    
    Integer lectureId,lecturerId;
    
    @Inject 
    LectureRepo lecturerepo;
    
    @Inject 
    LecturerRepo lecturerrepo;
   

    @PostConstruct
    public void init() {        
        lectureList = lecturerepo.findAll();
        
    }                      

    public Lectures getLecture() {
        return lecture;
    }

    public void setLecture(Lectures lecturer) {
        this.lecture = lecturer;
    }

    public List<Lectures> getLecturesList() {
        return lectureList;
    }

    public void setLecturesList(List<Lectures> lecturersList) {
        this.lectureList = lecturersList;
    }                               

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }        
    
    public void handleChange(ValueChangeEvent event){  
        System.out.println("Lecture here: "+event.getNewValue());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Lecturers getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturers lecturer) {
        this.lecturer = lecturer;
    }
        
    
    

    
     public void addLecture(){
        System.out.println("Lecturer ID: "+lecturerId);
        RequestContext context = RequestContext.getCurrentInstance();
        try{
        Lectures lect=new Lectures();
        lect.setRegDate(new Date());
        lect.setLecturerId(lecturerrepo.find(lecturerId));
        lect.setTitle(title);
        lect.setUrl("https://www.youtube.com/embed/"+Util.getVideoId(url));
        lect.setSource(source);
        lect.setExtra("0");
        lecturerepo.create(lect);
        }catch(Exception ex){
          ex.printStackTrace();
          FacesMessage msg = new FacesMessage("Error:"+ex.getMessage());   
          FacesContext.getCurrentInstance().addMessage(null, msg);                                 
        }
        source="";url="";title="";
        FacesMessage msg = new FacesMessage("Lecture added successfully"); 
        msg.setSummary("Successful");
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        context.addCallbackParam("loggedIn", true);        
    }
    
}


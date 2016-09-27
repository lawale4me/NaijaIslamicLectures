/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Ahmed
 */
@Named(value = "playMBean")
@Dependent
public class PlayMBean {

    
    String url="https://www.youtube.com/embed/zoVifvtTerk"; 
    /**
     * Creates a new instance of PlayMBean
     */
    public PlayMBean() {
        url="https://www.youtube.com/embed/zoVifvtTerk";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
    
}

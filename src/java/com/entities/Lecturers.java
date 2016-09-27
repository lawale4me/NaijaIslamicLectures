/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "lecturers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturers.findAll", query = "SELECT l FROM Lecturers l"),
    @NamedQuery(name = "Lecturers.findAllActive", query = "SELECT l FROM Lecturers l WHERE l.status=1"),
    @NamedQuery(name = "Lecturers.findByLecturerId", query = "SELECT l FROM Lecturers l WHERE l.lecturerId = :lecturerId"),
    @NamedQuery(name = "Lecturers.findByFullName", query = "SELECT l FROM Lecturers l WHERE l.fullName = :fullName"),
    @NamedQuery(name = "Lecturers.findByAlias", query = "SELECT l FROM Lecturers l WHERE l.alias = :alias"),
    @NamedQuery(name = "Lecturers.findByRegDate", query = "SELECT l FROM Lecturers l WHERE l.regDate = :regDate"),
    @NamedQuery(name = "Lecturers.findByLocation", query = "SELECT l FROM Lecturers l WHERE l.location = :location"),
    @NamedQuery(name = "Lecturers.findByExtra", query = "SELECT l FROM Lecturers l WHERE l.extra = :extra")})
public class Lecturers implements Serializable {
    @Column(name = "status")
    private Integer status;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lecturerId")
    private Integer lecturerId;
    @Size(max = 85)
    @Column(name = "FullName")
    private String fullName;
    @Size(max = 45)
    @Column(name = "Alias")
    private String alias;
    @Column(name = "regDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @Lob
    @Size(max = 65535)
    @Column(name = "extra1")
    private String extra1;
    @Size(max = 45)
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "lecturerId")
    private Collection<Lectures> lecturesCollection;

    public Lecturers() {
    }

    public Lecturers(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public Collection<Lectures> getLecturesCollection() {
        return lecturesCollection;
    }

    public void setLecturesCollection(Collection<Lectures> lecturesCollection) {
        this.lecturesCollection = lecturesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturerId != null ? lecturerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturers)) {
            return false;
        }
        Lecturers other = (Lecturers) object;
        if ((this.lecturerId == null && other.lecturerId != null) || (this.lecturerId != null && !this.lecturerId.equals(other.lecturerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Lecturers[ lecturerId=" + lecturerId + " ]";
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}

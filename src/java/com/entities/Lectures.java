/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "lectures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lectures.findAll", query = "SELECT l FROM Lectures l"),
    @NamedQuery(name = "Lectures.findAllActive", query = "SELECT l FROM Lectures l WHERE l.status = 1"),
    @NamedQuery(name = "Lectures.findByLectureId", query = "SELECT l FROM Lectures l WHERE l.lectureId = :lectureId"),
    @NamedQuery(name = "Lectures.findByLecturerId", query = "SELECT l FROM Lectures l WHERE l.lecturerId = :lecturerId"),
    @NamedQuery(name = "Lectures.findByRegDate", query = "SELECT l FROM Lectures l WHERE l.regDate = :regDate"),
    @NamedQuery(name = "Lectures.findByExtra", query = "SELECT l FROM Lectures l WHERE l.extra = :extra")})
public class Lectures implements Serializable {
    @Column(name = "status")
    private Integer status;
    @Lob
    @Size(max = 65535)
    @Column(name = "title")
    private String title;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lectureId")
    private Integer lectureId;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @Column(name = "regDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "source")
    private String source;
    @Size(max = 45)
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "lecturerId", referencedColumnName = "lecturerId")
    @ManyToOne
    private Lecturers lecturerId;

    public Lectures() {
    }

    public Lectures(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Lecturers getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Lecturers lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lectureId != null ? lectureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lectures)) {
            return false;
        }
        Lectures other = (Lectures) object;
        if ((this.lectureId == null && other.lectureId != null) || (this.lectureId != null && !this.lectureId.equals(other.lectureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Lectures[ lectureId=" + lectureId + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}

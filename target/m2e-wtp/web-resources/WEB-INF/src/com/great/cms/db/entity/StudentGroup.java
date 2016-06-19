/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arafat
 */
@Entity
@Table(name = "student_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s"),
    @NamedQuery(name = "StudentGroup.findByStudGroupId", query = "SELECT s FROM StudentGroup s WHERE s.studGroupId = :studGroupId")})
public class StudentGroup implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stud_group_id")
    private Integer studGroupId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private Groups groupId;

    public StudentGroup() {
    }

    public StudentGroup(Integer studGroupId) {
        this.studGroupId = studGroupId;
    }

    public Integer getStudGroupId() {
        return studGroupId;
    }

    public void setStudGroupId(Integer studGroupId) {
        this.studGroupId = studGroupId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studGroupId != null ? studGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentGroup)) {
            return false;
        }
        StudentGroup other = (StudentGroup) object;
        if ((this.studGroupId == null && other.studGroupId != null) || (this.studGroupId != null && !this.studGroupId.equals(other.studGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.StudentGroup[ studGroupId=" + studGroupId + " ]";
    }
    
}

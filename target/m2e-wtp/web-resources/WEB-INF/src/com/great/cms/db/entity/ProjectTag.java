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
@Table(name = "project_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectTag.findAll", query = "SELECT p FROM ProjectTag p"),
    @NamedQuery(name = "ProjectTag.findByProjectTagId", query = "SELECT p FROM ProjectTag p WHERE p.projectTagId = :projectTagId")})
public class ProjectTag implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_tag_id")
    private Integer projectTagId;
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    @ManyToOne(optional = false)
    private Tag tagId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;

    public ProjectTag() {
    }

    public ProjectTag(Integer projectTagId) {
        this.projectTagId = projectTagId;
    }

    public Integer getProjectTagId() {
        return projectTagId;
    }

    public void setProjectTagId(Integer projectTagId) {
        this.projectTagId = projectTagId;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectTagId != null ? projectTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTag)) {
            return false;
        }
        ProjectTag other = (ProjectTag) object;
        if ((this.projectTagId == null && other.projectTagId != null) || (this.projectTagId != null && !this.projectTagId.equals(other.projectTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.ProjectTag[ projectTagId=" + projectTagId + " ]";
    }
    
}

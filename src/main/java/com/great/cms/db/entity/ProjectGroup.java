/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arafat
 */
@Entity
@Table(name = "project_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectGroup.findAll", query = "SELECT p FROM ProjectGroup p"),
    @NamedQuery(name = "ProjectGroup.findByProjectGroupId", query = "SELECT p FROM ProjectGroup p WHERE p.projectGroupId = :projectGroupId")})
public class ProjectGroup implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_group_id")
    private Integer projectGroupId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private Groups groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectGroupId")
    private List<ProjectGroupSubmit> projectGroupSubmitList;

    public ProjectGroup() {
    }

    public ProjectGroup(Integer projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public Integer getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(Integer projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    public List<ProjectGroupSubmit> getProjectGroupSubmitList() {
        return projectGroupSubmitList;
    }

    public void setProjectGroupSubmitList(List<ProjectGroupSubmit> projectGroupSubmitList) {
        this.projectGroupSubmitList = projectGroupSubmitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectGroupId != null ? projectGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectGroup)) {
            return false;
        }
        ProjectGroup other = (ProjectGroup) object;
        if ((this.projectGroupId == null && other.projectGroupId != null) || (this.projectGroupId != null && !this.projectGroupId.equals(other.projectGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.ProjectGroup[ projectGroupId=" + projectGroupId + " ]";
    }
    
}

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
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectId", query = "SELECT p FROM Project p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Project.findByProjectTitle", query = "SELECT p FROM Project p WHERE p.projectTitle = :projectTitle"),
    @NamedQuery(name = "Project.findByProjectDesc", query = "SELECT p FROM Project p WHERE p.projectDesc = :projectDesc")})
public class Project implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @Basic(optional = false)
    @Column(name = "project_title")
    private String projectTitle;
    @Column(name = "project_desc")
    private String projectDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<ProjectGroup> projectGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<TaskProject> taskProjectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<ProjectTag> projectTagList;

    public Project() {
    }

    public Project(Integer projectId) {
        this.projectId = projectId;
    }

    public Project(Integer projectId, String projectTitle) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    @XmlTransient
    public List<ProjectGroup> getProjectGroupList() {
        return projectGroupList;
    }

    public void setProjectGroupList(List<ProjectGroup> projectGroupList) {
        this.projectGroupList = projectGroupList;
    }

    @XmlTransient
    public List<TaskProject> getTaskProjectList() {
        return taskProjectList;
    }

    public void setTaskProjectList(List<TaskProject> taskProjectList) {
        this.taskProjectList = taskProjectList;
    }

    @XmlTransient
    public List<ProjectTag> getProjectTagList() {
        return projectTagList;
    }

    public void setProjectTagList(List<ProjectTag> projectTagList) {
        this.projectTagList = projectTagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.Project[ projectId=" + projectId + " ]";
    }
    
}

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
@Table(name = "task_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskProject.findAll", query = "SELECT t FROM TaskProject t"),
    @NamedQuery(name = "TaskProject.findByTaskProjectId", query = "SELECT t FROM TaskProject t WHERE t.taskProjectId = :taskProjectId")})
public class TaskProject implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_project_id")
    private Integer taskProjectId;
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @ManyToOne(optional = false)
    private Task taskId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;

    public TaskProject() {
    }

    public TaskProject(Integer taskProjectId) {
        this.taskProjectId = taskProjectId;
    }

    public Integer getTaskProjectId() {
        return taskProjectId;
    }

    public void setTaskProjectId(Integer taskProjectId) {
        this.taskProjectId = taskProjectId;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
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
        hash += (taskProjectId != null ? taskProjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskProject)) {
            return false;
        }
        TaskProject other = (TaskProject) object;
        if ((this.taskProjectId == null && other.taskProjectId != null) || (this.taskProjectId != null && !this.taskProjectId.equals(other.taskProjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.TaskProject[ taskProjectId=" + taskProjectId + " ]";
    }
    
}

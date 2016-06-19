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
@Table(name = "task_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskType.findAll", query = "SELECT t FROM TaskType t"),
    @NamedQuery(name = "TaskType.findByTaskTypeId", query = "SELECT t FROM TaskType t WHERE t.taskTypeId = :taskTypeId"),
    @NamedQuery(name = "TaskType.findByTaskTypeName", query = "SELECT t FROM TaskType t WHERE t.taskTypeName = :taskTypeName")})
public class TaskType implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "task_type_id")
    private Integer taskTypeId;
    @Basic(optional = false)
    @Column(name = "task_type_name")
    private String taskTypeName;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "taskTypeId")
    private List<Task> taskList;

    public TaskType() {
    }

    public TaskType(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public TaskType(Integer taskTypeId, String taskTypeName) {
        this.taskTypeId = taskTypeId;
        this.taskTypeName = taskTypeName;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskTypeId != null ? taskTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskType)) {
            return false;
        }
        TaskType other = (TaskType) object;
        if ((this.taskTypeId == null && other.taskTypeId != null) || (this.taskTypeId != null && !this.taskTypeId.equals(other.taskTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.TaskType[ taskTypeId=" + taskTypeId + " ]";
    }
    
}

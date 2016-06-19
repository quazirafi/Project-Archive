/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.db.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arafat
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByTaskId", query = "SELECT t FROM Task t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "Task.findByTaskTitle", query = "SELECT t FROM Task t WHERE t.taskTitle = :taskTitle"),
    @NamedQuery(name = "Task.findByTaskDesc", query = "SELECT t FROM Task t WHERE t.taskDesc = :taskDesc"),
    @NamedQuery(name = "Task.findByTaskDeadline", query = "SELECT t FROM Task t WHERE t.taskDeadline = :taskDeadline"),
    @NamedQuery(name = "Task.findByTaskTotalGroupNo", query = "SELECT t FROM Task t WHERE t.taskTotalGroupNo = :taskTotalGroupNo"),
    @NamedQuery(name = "Task.findByTaskTotalSubmissonNo", query = "SELECT t FROM Task t WHERE t.taskTotalSubmissonNo = :taskTotalSubmissonNo"),
    @NamedQuery(name = "Task.findByIsOpen", query = "SELECT t FROM Task t WHERE t.isOpen = :isOpen")})
public class Task implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Basic(optional = false)
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_desc")
    private String taskDesc;
    @Basic(optional = false)
    @Column(name = "task_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskDeadline;
    @Basic(optional = false)
    @Column(name = "task_total_group_no")
    private int taskTotalGroupNo;
    @Basic(optional = false)
    @Column(name = "task_total_submisson_no")
    private int taskTotalSubmissonNo;
    @Basic(optional = false)
    @Column(name = "is_open")
    private boolean isOpen;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "taskId")
    private CourseTask courseTask;
    @JoinColumn(name = "task_type_id", referencedColumnName = "task_type_id")
    @ManyToOne(optional = false)
    private TaskType taskTypeId;

    public Task() {
    }

    public Task(Integer taskId) {
        this.taskId = taskId;
    }

    public Task(Integer taskId, String taskTitle, Date taskDeadline, int taskTotalGroupNo, int taskTotalSubmissonNo, boolean isOpen) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDeadline = taskDeadline;
        this.taskTotalGroupNo = taskTotalGroupNo;
        this.taskTotalSubmissonNo = taskTotalSubmissonNo;
        this.isOpen = isOpen;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public int getTaskTotalGroupNo() {
        return taskTotalGroupNo;
    }

    public void setTaskTotalGroupNo(int taskTotalGroupNo) {
        this.taskTotalGroupNo = taskTotalGroupNo;
    }

    public int getTaskTotalSubmissonNo() {
        return taskTotalSubmissonNo;
    }

    public void setTaskTotalSubmissonNo(int taskTotalSubmissonNo) {
        this.taskTotalSubmissonNo = taskTotalSubmissonNo;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public CourseTask getCourseTask() {
        return courseTask;
    }

    public void setCourseTask(CourseTask courseTask) {
        this.courseTask = courseTask;
    }

    public TaskType getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(TaskType taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.Task[ taskId=" + taskId + " ]";
    }
    
}

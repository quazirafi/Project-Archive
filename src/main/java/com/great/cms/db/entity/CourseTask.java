/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.db.entity;

import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.ExamCommittee;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arafat
 */
@Entity
@Table(name = "course_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseTask.findAll", query = "SELECT c FROM CourseTask c"),
    @NamedQuery(name = "CourseTask.findByCourseTaskId", query = "SELECT c FROM CourseTask c WHERE c.courseTaskId = :courseTaskId")})
public class CourseTask implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_task_id")
    private Integer courseTaskId;
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @OneToOne(optional = false)
    private Task taskId;
    @JoinColumn(name = "exam_committee_id", referencedColumnName = "exam_committee_id")
    @ManyToOne(optional = false)
    private ExamCommittee examCommitteeId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseTask() {
    }

    public CourseTask(Integer courseTaskId) {
        this.courseTaskId = courseTaskId;
    }

    public Integer getCourseTaskId() {
        return courseTaskId;
    }

    public void setCourseTaskId(Integer courseTaskId) {
        this.courseTaskId = courseTaskId;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
    }

    public ExamCommittee getExamCommitteeId() {
        return examCommitteeId;
    }

    public void setExamCommitteeId(ExamCommittee examCommitteeId) {
        this.examCommitteeId = examCommitteeId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseTaskId != null ? courseTaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseTask)) {
            return false;
        }
        CourseTask other = (CourseTask) object;
        if ((this.courseTaskId == null && other.courseTaskId != null) || (this.courseTaskId != null && !this.courseTaskId.equals(other.courseTaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.CourseTask[ courseTaskId=" + courseTaskId + " ]";
    }
    
}

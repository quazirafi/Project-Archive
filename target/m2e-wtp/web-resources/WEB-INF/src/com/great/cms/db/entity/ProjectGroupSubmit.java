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
@Table(name = "project_group_submit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectGroupSubmit.findAll", query = "SELECT p FROM ProjectGroupSubmit p"),
    @NamedQuery(name = "ProjectGroupSubmit.findByProjectGroupSubmitId", query = "SELECT p FROM ProjectGroupSubmit p WHERE p.projectGroupSubmitId = :projectGroupSubmitId")})
public class ProjectGroupSubmit implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_group_submit_id")
    private Integer projectGroupSubmitId;
    @JoinColumn(name = "submission_id", referencedColumnName = "submission_id")
    @ManyToOne(optional = false)
    private Submission submissionId;
    @JoinColumn(name = "project_group_id", referencedColumnName = "project_group_id")
    @ManyToOne(optional = false)
    private ProjectGroup projectGroupId;

    public ProjectGroupSubmit() {
    }

    public ProjectGroupSubmit(Integer projectGroupSubmitId) {
        this.projectGroupSubmitId = projectGroupSubmitId;
    }

    public Integer getProjectGroupSubmitId() {
        return projectGroupSubmitId;
    }

    public void setProjectGroupSubmitId(Integer projectGroupSubmitId) {
        this.projectGroupSubmitId = projectGroupSubmitId;
    }

    public Submission getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Submission submissionId) {
        this.submissionId = submissionId;
    }

    public ProjectGroup getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(ProjectGroup projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectGroupSubmitId != null ? projectGroupSubmitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectGroupSubmit)) {
            return false;
        }
        ProjectGroupSubmit other = (ProjectGroupSubmit) object;
        if ((this.projectGroupSubmitId == null && other.projectGroupSubmitId != null) || (this.projectGroupSubmitId != null && !this.projectGroupSubmitId.equals(other.projectGroupSubmitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.ProjectGroupSubmit[ projectGroupSubmitId=" + projectGroupSubmitId + " ]";
    }
    
}

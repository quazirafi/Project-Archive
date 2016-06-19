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
@Table(name = "submission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findBySubmissionId", query = "SELECT s FROM Submission s WHERE s.submissionId = :submissionId"),
    @NamedQuery(name = "Submission.findByCommentStudent", query = "SELECT s FROM Submission s WHERE s.commentStudent = :commentStudent"),
    @NamedQuery(name = "Submission.findBySubmissionVer", query = "SELECT s FROM Submission s WHERE s.submissionVer = :submissionVer"),
    @NamedQuery(name = "Submission.findByCommentTeacher", query = "SELECT s FROM Submission s WHERE s.commentTeacher = :commentTeacher"),
    @NamedQuery(name = "Submission.findBySubmissionTime", query = "SELECT s FROM Submission s WHERE s.submissionTime = :submissionTime")})
public class Submission implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "submission_id")
    private Integer submissionId;
    @Column(name = "comment_student")
    private String commentStudent;
    @Column(name = "submission_ver")
    private Integer submissionVer;
    @Column(name = "comment_teacher")
    private String commentTeacher;
    @Basic(optional = false)
    @Column(name = "submission_time")
    private String submissionTime;
    @Column(name="submission_url")
    private String submissionUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submissionId")
    private List<ProjectGroupSubmit> projectGroupSubmitList;

    public Submission() {
    }

    public Submission(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Submission(Integer submissionId, String submissionTime) {
        this.submissionId = submissionId;
        this.submissionTime = submissionTime;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public String getCommentStudent() {
        return commentStudent;
    }

    public void setCommentStudent(String commentStudent) {
        this.commentStudent = commentStudent;
    }

    public Integer getSubmissionVer() {
        return submissionVer;
    }

    public void setSubmissionVer(Integer submissionVer) {
        this.submissionVer = submissionVer;
    }

    public String getCommentTeacher() {
        return commentTeacher;
    }

    public void setCommentTeacher(String commentTeacher) {
        this.commentTeacher = commentTeacher;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }
    
    public void setSubmissionUrl(String submissionUrl){
    	this.submissionUrl = submissionUrl;
    }
    
    public String getSubmissionUrl()
    {
    	return submissionUrl;
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
        hash += (submissionId != null ? submissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.submissionId == null && other.submissionId != null) || (this.submissionId != null && !this.submissionId.equals(other.submissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sustarchive.app.model.Submission[ submissionId=" + submissionId +"submissionComment="+commentTeacher+" submissionUrl="+submissionUrl+ " ]";
    }
    
}

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
 * @author SultanaRazia
 */
@Entity
@Table(name = "question_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionType.findAll", query = "SELECT q FROM QuestionType q"),
    @NamedQuery(name = "QuestionType.findByQuestionTypeId", query = "SELECT q FROM QuestionType q WHERE q.questionTypeId = :questionTypeId"),
    @NamedQuery(name = "QuestionType.findByQuestionTypeName", query = "SELECT q FROM QuestionType q WHERE q.questionTypeName = :questionTypeName")})
public class QuestionType implements Serializable,DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "question_type_id")
    private Integer questionTypeId;
    @Basic(optional = false)
    @Column(name = "question_type_name")
    private String questionTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionTypeId")
    private List<Question> questionList;

    public QuestionType() {
    }

    public QuestionType(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public QuestionType(Integer questionTypeId, String questionTypeName) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionTypeId != null ? questionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionType)) {
            return false;
        }
        QuestionType other = (QuestionType) object;
        if ((this.questionTypeId == null && other.questionTypeId != null) || (this.questionTypeId != null && !this.questionTypeId.equals(other.questionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.QuestionType[ questionTypeId=" + questionTypeId + " ]";
    }
    
}

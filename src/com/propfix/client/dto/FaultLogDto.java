/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.dto;

import com.propfix.client.dto.JobTypeDto;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Y3850910
 */
public class FaultLogDto implements Serializable {

    private int faultLogId;
    private String tenantId;
    private String propertyId;
    private JobTypeDto jobType;
    private String faultDescription;
    private Date dateCreated;
    private String status;
    private String acceptedBy;
    private Date dateAccepted;
    private String contractorComment;
    private boolean aknowledgementStatus;
    private String repairFeedback;

    public FaultLogDto(int faultLogId, String tenantId, String propertyId, JobTypeDto jobType,
            String faultDescription, Date dateCreated, String status, String acceptedBy, Date dateAccepted,
            String contractorComment, boolean aknowledgementStatus, String repairFeedback) {
        this.faultLogId = faultLogId;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.jobType = jobType;
        this.faultDescription = faultDescription;
        this.dateCreated = dateCreated;
        this.status = status;
        this.acceptedBy = acceptedBy;
        this.dateAccepted = dateAccepted;
        this.contractorComment = contractorComment;
        this.aknowledgementStatus = aknowledgementStatus;
        this.repairFeedback = repairFeedback;
    }

    public int getFaultLogId() {
        return faultLogId;
    }

    public void setFaultLogId(int faultLogId) {
        this.faultLogId = faultLogId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public JobTypeDto getJobType() {
        return jobType;
    }

    public void setJobType(JobTypeDto jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return faultDescription;
    }

    public void setDescription(String description) {
        this.faultDescription = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public Date getDateAccepted() {
        return dateAccepted;
    }

    public void setDateAccepted(Date dateAccepted) {
        this.dateAccepted = dateAccepted;
    }

    public String getContractorComment() {
        return contractorComment;
    }

    public void setContractorComment(String contractorComment) {
        this.contractorComment = contractorComment;
    }

    public boolean isAknowledgementStatus() {
        return aknowledgementStatus;
    }

    public void setAknowledgementStatus(boolean aknowledgementStatus) {
        this.aknowledgementStatus = aknowledgementStatus;
    }

    public String getRepairFeedback() {
        return repairFeedback;
    }

    public void setRepairFeedback(String repairFeedback) {
        this.repairFeedback = repairFeedback;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.faultLogId;
        hash = 67 * hash + Objects.hashCode(this.tenantId);
        hash = 67 * hash + Objects.hashCode(this.propertyId);
        hash = 67 * hash + Objects.hashCode(this.jobType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FaultLogDto other = (FaultLogDto) obj;
        if (this.faultLogId != other.faultLogId) {
            return false;
        }
        if (!Objects.equals(this.tenantId, other.tenantId)) {
            return false;
        }
        if (!Objects.equals(this.propertyId, other.propertyId)) {
            return false;
        }
        if (!Objects.equals(this.jobType, other.jobType)) {
            return false;
        }
        return true;
    }

}

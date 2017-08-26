/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.dto;

import java.io.Serializable;

/**
 *
 * @author Y3850910
 */
public class JobTypeDto implements Serializable {

    private int jobTypeId;
    private String jobType;
    private String description;

    public JobTypeDto() {
    }

    public JobTypeDto(int jobTypeId, String jobType, String description) {
        this.jobTypeId = jobTypeId;
        this.jobType = jobType;
        this.description = description;
    }

    public int getFaultId() {
        return jobTypeId;
    }

    public void setFaultId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public String getFaultType() {
        return jobType;
    }

    public void setFaultType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.jobTypeId;
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
        final JobTypeDto other = (JobTypeDto) obj;
        if (this.jobTypeId != other.jobTypeId) {
            return false;
        }
        return true;
    }

}

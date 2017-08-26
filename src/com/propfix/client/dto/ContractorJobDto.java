/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Y3850910
 */
public class ContractorJobDto implements Serializable{
    
	private int jobId;
    private ContractorDto contractor;
    private JobTypeDto jobType;
    private String description;

    public ContractorJobDto() {
    }

    public ContractorJobDto(int jobId, ContractorDto contractor, JobTypeDto jobType, String description) {
        this.jobId = jobId;
    	this.contractor = contractor;
        this.jobType = jobType;
        this.description = description;
    }

    public void setJobId(int jobId) {
		this.jobId = jobId;
	}
    
    public int getJobId() {
		return jobId;
	}
    
    public ContractorDto getContractor() {
        return contractor;
    }

    public void setContractor(ContractorDto contractor) {
        this.contractor = contractor;
    }

    public JobTypeDto getjobType() {
        return jobType;
    }

    public void setjobType(JobTypeDto jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}

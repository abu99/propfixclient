/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;
import java.util.Objects;


public class JobDto implements Serializable, IsSerializable {
    
    private String job;
    private String description;

    public JobDto(String job, String description) {
        this.job = job;
        this.description = description;
    }
   
    public JobDto() {
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.job);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JobDto other = (JobDto) obj;
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        return true;
    }
    
}

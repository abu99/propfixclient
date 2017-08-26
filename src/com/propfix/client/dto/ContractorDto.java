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
public class ContractorDto implements Serializable{
    
    private String contractorId;
    private String surname;
    private String firstName;
    private String middleName;
    private String gender;
    private String email;

    public ContractorDto() {
    }

    public ContractorDto(String contractorId, String surname, String firstName, String middleName, String gender, String email) {
        this.contractorId = contractorId;
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.email = email;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.contractorId);
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
        final ContractorDto other = (ContractorDto) obj;
        if (!Objects.equals(this.contractorId, other.contractorId)) {
            return false;
        }
        return true;
    }
    
    
    
}

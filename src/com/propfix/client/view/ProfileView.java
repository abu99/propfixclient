/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.propfix.client.presenter.ProfilePresenter;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;

/**
 *
 * @author Y3850910
 */
public class ProfileView extends Composite implements ProfilePresenter.Display {
   
    private final MaterialTextBox surname;
    private final MaterialTextBox firstName;
    private final MaterialTextBox lastName;
    private final MaterialTextBox middleName;
    private final MaterialTextBox email;
    private final MaterialRadioButton male;
    private final MaterialRadioButton female;
    private final MaterialButton saveButton;
    private final MaterialTextBox propId;

    public ProfileView() {
        
        MaterialPanel vPanel = new MaterialPanel();
        vPanel.setWidth("50%");
        initWidget(vPanel);
        
        surname = new MaterialTextBox();
        surname.setPlaceholder("Your Surname");
        
        firstName = new MaterialTextBox();
        firstName.setPlaceholder("Your first Name");
        
        lastName = new MaterialTextBox();
        lastName.setPlaceholder("Your last Name");
        
        middleName = new MaterialTextBox();
        middleName.setPlaceholder("Your Middle Name");
        
        email = new MaterialTextBox();
        email.setPlaceholder("Your email address");
        
        male = new MaterialRadioButton("", "Male");
        female = new MaterialRadioButton("", "Female");
        
        propId = new MaterialTextBox();
        propId.setPlaceholder("Property ID");
        
        saveButton = new MaterialButton(
                ButtonType.RAISED, "Update Profile", new MaterialIcon(IconType.EDIT));
        saveButton.setWaves(WavesType.LIGHT);
        saveButton.setIconPosition(IconPosition.LEFT);
        
        vPanel.add(propId);
        vPanel.add(surname);
        vPanel.add(firstName);
        vPanel.add(middleName);
        vPanel.add(email);
        
        HorizontalPanel genderPanel = new HorizontalPanel();
//        genderPanel.setSpacing(1);
        
//        genderPanel.add(male);
//        genderPanel.add(female);
        
        vPanel.add(genderPanel);
        
        vPanel.add(saveButton);
        
    }
    
    @Override
    public MaterialTextBox getSurnameText() {
        return surname;
    }

    @Override
    public MaterialTextBox getFirstName() {
        return lastName;
    }

    @Override
    public MaterialTextBox getMiddleName() {
        return middleName;
    }

    @Override
    public MaterialRadioButton getFemaleGender() {
        return male;
    }

    @Override
    public MaterialRadioButton getMaleGender() {
        return female;
    }

    @Override
    public MaterialTextBox getEmal() {
        return email;
    }

    @Override
    public MaterialTextBox getPropId() {
        return propId;
    }

    @Override
    public MaterialButton getSaveButton() {
        return saveButton;
    }
}
